package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ReflectiveGenericLifecycleObserver implements a {
    static final Map<Class, a> a = new HashMap();
    private final Object b;
    private final a c = a(this.b.getClass());

    static class a {
        final Map<android.arch.lifecycle.b.a, List<b>> a = new HashMap();
        final Map<b, android.arch.lifecycle.b.a> b;

        a(Map<b, android.arch.lifecycle.b.a> map) {
            this.b = map;
            for (Entry entry : map.entrySet()) {
                android.arch.lifecycle.b.a aVar = (android.arch.lifecycle.b.a) entry.getValue();
                List list = (List) this.a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(aVar, list);
                }
                list.add(entry.getKey());
            }
        }
    }

    static class b {
        final int a;
        final Method b;

        b(int i, Method method) {
            this.a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.b.getName().hashCode();
        }
    }

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.b = obj;
    }

    private static a a(Class cls) {
        a aVar = (a) a.get(cls);
        return aVar != null ? aVar : b(cls);
    }

    private void a(a aVar, c cVar, android.arch.lifecycle.b.a aVar2) {
        a((List) aVar.a.get(aVar2), cVar, aVar2);
        a((List) aVar.a.get(android.arch.lifecycle.b.a.ON_ANY), cVar, aVar2);
    }

    private void a(b bVar, c cVar, android.arch.lifecycle.b.a aVar) {
        try {
            switch (bVar.a) {
                case 0:
                    bVar.b.invoke(this.b, new Object[0]);
                    return;
                case 1:
                    bVar.b.invoke(this.b, new Object[]{cVar});
                    return;
                case 2:
                    bVar.b.invoke(this.b, new Object[]{cVar, aVar});
                    return;
                default:
                    return;
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Failed to call observer method", e.getCause());
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private void a(List<b> list, c cVar, android.arch.lifecycle.b.a aVar) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                a((b) list.get(size), cVar, aVar);
            }
        }
    }

    private static void a(Map<b, android.arch.lifecycle.b.a> map, b bVar, android.arch.lifecycle.b.a aVar, Class cls) {
        android.arch.lifecycle.b.a aVar2 = (android.arch.lifecycle.b.a) map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            throw new IllegalArgumentException("Method " + bVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private static a b(Class cls) {
        a a;
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            a = a(superclass);
            if (a != null) {
                hashMap.putAll(a.b);
            }
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Class a2 : cls.getInterfaces()) {
            for (Entry entry : a(a2).b.entrySet()) {
                a(hashMap, (b) entry.getKey(), (android.arch.lifecycle.b.a) entry.getValue(), cls);
            }
        }
        for (Method method : declaredMethods) {
            f fVar = (f) method.getAnnotation(f.class);
            if (fVar != null) {
                int i;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(c.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                android.arch.lifecycle.b.a a3 = fVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(android.arch.lifecycle.b.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a3 != android.arch.lifecycle.b.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new b(i, method), a3, cls);
            }
        }
        a = new a(hashMap);
        a.put(cls, a);
        return a;
    }

    public void a(c cVar, android.arch.lifecycle.b.a aVar) {
        a(this.c, cVar, aVar);
    }
}
