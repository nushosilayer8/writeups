package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.b.c;
import android.util.Log;
import java.util.Calendar;

class q {
    private static q a;
    private final Context b;
    private final LocationManager c;
    private final a d = new a();

    private static class a {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }

    q(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    private Location a(String str) {
        if (this.c != null) {
            try {
                if (this.c.isProviderEnabled(str)) {
                    return this.c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    static q a(Context context) {
        if (a == null) {
            Context applicationContext = context.getApplicationContext();
            a = new q(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return a;
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        p a = p.a();
        a.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.a;
        a.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.c == 1;
        long j3 = a.b;
        long j4 = a.a;
        a.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        aVar.a = z;
        aVar.b = j2;
        aVar.c = j3;
        aVar.d = j4;
        aVar.e = j5;
        aVar.f = j;
    }

    private Location b() {
        Location location = null;
        Location a = c.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (c.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    private boolean c() {
        return this.d != null && this.d.f > System.currentTimeMillis();
    }

    boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.a;
        }
        Location b = b();
        if (b != null) {
            a(b);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
