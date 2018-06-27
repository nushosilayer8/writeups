package android.support.v4.b.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a {

    public interface a {
    }

    public static final class b implements a {
        private final c[] a;

        public b(c[] cVarArr) {
            this.a = cVarArr;
        }

        public c[] a() {
            return this.a;
        }
    }

    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private int d;

        public c(String str, int i, boolean z, int i2) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = i2;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }
    }

    public static final class d implements a {
        private final android.support.v4.f.a a;
        private final int b;
        private final int c;

        public d(android.support.v4.f.a aVar, int i, int i2) {
            this.a = aVar;
            this.c = i;
            this.b = i2;
        }

        public android.support.v4.f.a a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                List<List<byte[]>> arrayList = new ArrayList();
                if ((obtainTypedArray.getResourceId(0, 0) != 0 ? 1 : 0) != 0) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(a(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                    list = arrayList;
                } else {
                    arrayList.add(a(resources.getStringArray(i)));
                    list = arrayList;
                }
            }
            obtainTypedArray.recycle();
        }
        return list != null ? list : Collections.emptyList();
    }

    private static List<byte[]> a(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), android.support.a.a.a.FontFamily);
        String string = obtainAttributes.getString(android.support.a.a.a.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(android.support.a.a.a.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(android.support.a.a.a.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(android.support.a.a.a.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(android.support.a.a.a.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(android.support.a.a.a.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(d(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            return arrayList.isEmpty() ? null : new b((c[]) arrayList.toArray(new c[arrayList.size()]));
        } else {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new android.support.v4.f.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
    }

    private static c d(XmlPullParser xmlPullParser, Resources resources) {
        boolean z = true;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), android.support.a.a.a.FontFamilyFont);
        int i = obtainAttributes.getInt(android.support.a.a.a.FontFamilyFont_fontWeight, 400);
        if (1 != obtainAttributes.getInt(android.support.a.a.a.FontFamilyFont_fontStyle, 0)) {
            z = false;
        }
        int resourceId = obtainAttributes.getResourceId(android.support.a.a.a.FontFamilyFont_font, 0);
        String string = obtainAttributes.getString(android.support.a.a.a.FontFamilyFont_font);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new c(string, i, z, resourceId);
    }
}
