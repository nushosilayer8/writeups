package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b implements Closeable {
    private final File a;
    private final long b;
    private final File c;
    private final RandomAccessFile d;
    private final FileChannel e;
    private final FileLock f;

    private static class a extends File {
        public long a = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    b(File file, File file2) {
        RuntimeException e;
        IOException e2;
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.a = file;
        this.c = file2;
        this.b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.d = new RandomAccessFile(file3, "rw");
        try {
            this.e = this.d.getChannel();
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f = this.e.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e3) {
                e = e3;
                a(this.e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                a(this.e);
                throw e;
            } catch (Error e5) {
                e = e5;
                a(this.e);
                throw e;
            }
        } catch (IOException e6) {
            e2 = e6;
            a(this.d);
            throw e2;
        } catch (RuntimeException e7) {
            e2 = e7;
            a(this.d);
            throw e2;
        } catch (Error e8) {
            e2 = e8;
            a(this.d);
            throw e2;
        }
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private List<a> a() {
        String str = this.a.getName() + ".classes";
        b();
        List<a> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.a);
        ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
        int i = 2;
        while (entry != null) {
            File aVar = new a(this.c, str + i + ".zip");
            arrayList.add(aVar);
            Log.i("MultiDex", "Extraction is needed for file " + aVar);
            Object obj = null;
            int i2 = 0;
            while (i2 < 3 && obj == null) {
                int i3 = i2 + 1;
                a(zipFile, entry, aVar, str);
                try {
                    aVar.a = b(aVar);
                    obj = 1;
                } catch (Throwable e) {
                    Log.w("MultiDex", "Failed to read crc from " + aVar.getAbsolutePath(), e);
                    obj = null;
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                    } catch (Throwable e2) {
                        Log.w("MultiDex", "Failed to close resource", e2);
                    }
                }
                Log.i("MultiDex", "Extraction " + (obj != null ? "succeeded" : "failed") + " '" + aVar.getAbsolutePath() + "': length " + aVar.length() + " - crc: " + aVar.a);
                if (obj == null) {
                    aVar.delete();
                    if (aVar.exists()) {
                        Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                        i2 = i3;
                    }
                }
                i2 = i3;
            }
            if (obj == null) {
                throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i + ")");
            }
            int i4 = i + 1;
            entry = zipFile.getEntry("classes" + i4 + ".dex");
            i = i4;
        }
        try {
            zipFile.close();
        } catch (Throwable e3) {
            Log.w("MultiDex", "Failed to close resource", e3);
        }
        return arrayList;
    }

    private List<a> a(Context context, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.a.getName() + ".classes";
        SharedPreferences a = a(context);
        int i = a.getInt(str + "dex.number", 1);
        List<a> arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            File aVar = new a(this.c, str2 + i2 + ".zip");
            if (aVar.isFile()) {
                aVar.a = b(aVar);
                long j = a.getLong(str + "dex.crc." + i2, -1);
                long j2 = a.getLong(str + "dex.time." + i2, -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified && j == aVar.a) {
                    arrayList.add(aVar);
                    i2++;
                } else {
                    throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + aVar.a);
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
        }
        return arrayList;
    }

    private static void a(Context context, String str, long j, long j2, List<a> list) {
        Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a aVar = (a) it.next();
                edit.putLong(str + "dex.crc." + i2, aVar.a);
                edit.putLong(str + "dex.time." + i2, aVar.lastModified());
                i = i2 + 1;
            } else {
                edit.commit();
                return;
            }
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    a(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            a(inputStream);
            createTempFile.delete();
        }
    }

    private static boolean a(Context context, File file, long j, String str) {
        SharedPreferences a = a(context);
        return (a.getLong(new StringBuilder().append(str).append("timestamp").toString(), -1) == a(file) && a.getLong(str + "crc", -1) == j) ? false : true;
    }

    private static long b(File file) {
        long a = c.a(file);
        return a == -1 ? a - 1 : a;
    }

    private void b() {
        File[] listFiles = this.c.listFiles(new FileFilter(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    List<? extends File> a(Context context, String str, boolean z) {
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.a.getPath() + ", " + z + ", " + str + ")");
        if (this.f.isValid()) {
            List<? extends File> a;
            if (z || a(context, this.a, this.b, str)) {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                a = a();
                a(context, str, a(this.a), this.b, a);
            } else {
                try {
                    a = a(context, str);
                } catch (Throwable e) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                    a = a();
                    a(context, str, a(this.a), this.b, a);
                }
            }
            Log.i("MultiDex", "load found " + a.size() + " secondary dex files");
            return a;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() {
        this.f.release();
        this.e.close();
        this.d.close();
    }
}
