//package com.excalibur.funwithgles.sdmaidpro.tools.io;
//
//import com.excalibur.funwithgles.App;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Pattern;
//
///* compiled from: FileOpsHelper */
//public final class g {
//
//    /* renamed from: a  reason: collision with root package name */
//    static final String f3837a = App.self().a("FileOpsHelper");
//
//    public static String a(int i) {
//        String format = String.format("%03d", new Object[]{Integer.valueOf(i)});
//        StringBuilder sb = new StringBuilder();
//        for (int i2 = 0; i2 < format.length(); i2++) {
//            int parseInt = Integer.parseInt(String.valueOf(format.charAt(i2)));
//            char c = '-';
//            sb.append((parseInt & 4) == 0 ? '-' : 'r');
//            sb.append((parseInt & 2) == 0 ? '-' : 'w');
//            if ((parseInt & 1) != 0) {
//                c = 'x';
//            }
//            sb.append(c);
//        }
//        return sb.toString();
//    }
//
//    public static boolean a(File file) {
//        boolean z;
//        File[] listFiles;
//        if (!file.exists()) {
//            try {
//                throw new FileNotFoundException(file.getAbsolutePath());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
//            z = true;
//        } else {
//            z = true;
//            for (File a2 : listFiles) {
//                z = z && a(a2);
//            }
//        }
//        //a.b(f3837a).a("deleteRecursive:" + file.getPath(), new Object[0]);
//        return z && file.delete();
//    }
//
//    private static List<String> b(File file) {
//        ArrayList arrayList = new ArrayList();
//        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
//            arrayList.add(parentFile.getAbsolutePath());
//        }
//        return arrayList;
//    }
//
//    public static Map<p, Collection<p>> a(Collection<p> collection) {
//        HashSet hashSet = new HashSet(collection);
//        HashSet<p> hashSet2 = new HashSet<>(collection);
//        HashSet hashSet3 = new HashSet();
//        for (p next : collection) {
//            if (hashSet.contains(next.g())) {
//                hashSet2.remove(next);
//                hashSet3.add(next);
//            }
//        }
//        HashMap hashMap = new HashMap();
//        for (p pVar : hashSet2) {
//            HashSet hashSet4 = new HashSet();
//            Iterator it = hashSet3.iterator();
//            while (it.hasNext()) {
//                p pVar2 = (p) it.next();
//                String c = pVar2.c();
//                if (c.startsWith(pVar.c() + File.separator)) {
//                    hashSet4.add(pVar2);
//                    it.remove();
//                }
//            }
//            hashMap.put(pVar, hashSet4);
//        }
//        return hashMap;
//    }
//
//    public static void a(List<p> list, List<Exclusion> list2) {
//        HashSet hashSet = new HashSet();
//        for (Exclusion next : list2) {
//            Iterator<p> it = list.iterator();
//            while (it.hasNext()) {
//                p next2 = it.next();
//                if (next.a(next2.c())) {
//                    hashSet.addAll(b(next2.d()));
//                    it.remove();
//                }
//            }
//        }
//        if (!hashSet.isEmpty()) {
//            Iterator<p> it2 = list.iterator();
//            while (it2.hasNext()) {
//                p next3 = it2.next();
//                if (hashSet.contains(next3.c())) {
//                    a.b(f3837a).a("Indirectly excluded parent: %s", next3);
//                    it2.remove();
//                }
//            }
//        }
//    }
//
//    public static b a(Collection<b> collection, p pVar) {
//        return a(collection, pVar.d());
//    }
//
//    public static b a(Collection<b> collection, File file) {
//        if (file == null) {
//            return null;
//        }
//        File file2 = new File(file.getPath());
//        while (file2 != null) {
//            try {
//                for (b next : collection) {
//                    if (next.f3916a.c().equals(file2.getPath())) {
//                        return next;
//                    }
//                }
//                file2 = file2.getParentFile();
//            } catch (Exception e) {
//                a.b(f3837a).c(e, "Error while trying to find mountpoint.", new Object[0]);
//            }
//        }
//        a.b(f3837a).d("Couldn't find mountpoint for: %s", file);
//        return null;
//    }
//
//    public static Collection<p> b(Collection<p> collection) {
//        HashSet hashSet = new HashSet(collection);
//        for (p next : collection) {
//            for (p next2 : collection) {
//                if (!next.equals(next2) && a(next, next2)) {
//                    hashSet.remove(next2);
//                }
//            }
//        }
//        return hashSet;
//    }
//
//    public static String a(String str) {
//        int lastIndexOf = str.lastIndexOf(File.separator);
//        if (lastIndexOf == -1) {
//            return null;
//        }
//        return str.substring(0, lastIndexOf);
//    }
//
//    public static String b(String str) {
//        if (str.startsWith(File.separator)) {
//            str = str.substring(1);
//        }
//        return str.split(Pattern.quote(File.separator))[0];
//    }
//
//    public static Collection<p> a(p pVar, Collection<p> collection) {
//        HashSet hashSet = new HashSet();
//        for (p next : collection) {
//            if (a(pVar, next)) {
//                hashSet.add(next);
//            }
//        }
//        return hashSet;
//    }
//
//    public static <T extends p> Collection<T> a(Collection<T> collection, Collection<T> collection2) {
//        HashSet hashSet = new HashSet();
//        for (T t : collection) {
//            for (T t2 : collection2) {
//                if (a(t, t2)) {
//                    hashSet.add(t2);
//                }
//            }
//        }
//        return hashSet;
//    }
//
//    public static <T extends p> boolean a(T t, T t2) {
//        return a(t.d(), t2.d());
//    }
//
//    public static boolean a(File file, File file2) {
//        for (File parentFile = file2.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
//            if (file.getAbsolutePath().equals(parentFile.getAbsolutePath())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
//    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
//        return;
//     */
//    /* JADX WARNING: Failed to process nested try/catch */
//    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0067 */
//    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075 A[SYNTHETIC, Splitter:B:29:0x0075] */
//    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a A[SYNTHETIC, Splitter:B:33:0x007a] */
//    public static void b(p pVar, p pVar2) {
//        FileInputStream fileInputStream;
//        FileOutputStream fileOutputStream;
//        a.b(f3837a).b("Copying %s -> %s", pVar, pVar2);
//        if (pVar2.d().exists() && !pVar2.d().canWrite()) {
//            a.b(f3837a).b("Target exists, but isn't writable, correcting... success: %b", Boolean.valueOf(pVar2.d().setWritable(true)));
//        }
//        FileOutputStream fileOutputStream2 = null;
//        try {
//            fileInputStream = new FileInputStream(pVar.c());
//            try {
//                fileOutputStream = new FileOutputStream(pVar2.c());
//            } catch (Throwable th) {
//                th = th;
//                if (fileInputStream != null) {
//                }
//                if (fileOutputStream2 != null) {
//                }
//                throw th;
//            }
//            try {
//                byte[] bArr = new byte[4096];
//                while (true) {
//                    int read = fileInputStream.read(bArr);
//                    if (read > 0) {
//                        fileOutputStream.write(bArr, 0, read);
//                    } else {
//                        fileInputStream.close();
//                        fileOutputStream.close();
//                        return;
//                    }
//                }
//            } catch (Throwable th2) {
//                th = th2;
//                fileOutputStream2 = fileOutputStream;
//                if (fileInputStream != null) {
//                }
//                if (fileOutputStream2 != null) {
//                }
//                throw th;
//            }
//        } catch (Throwable th3) {
//            th = th3;
//            fileInputStream = null;
//            if (fileInputStream != null) {
//                try {
//                    fileInputStream.close();
//                } catch (Exception unused) {
//                }
//            }
//            if (fileOutputStream2 != null) {
//                try {
//                    fileOutputStream2.close();
//                } catch (Exception unused2) {
//                }
//            }
//            throw th;
//        }
//    }
//
//    public static Collection<String> c(Collection<p> collection) {
//        ArrayList arrayList = new ArrayList();
//        for (p c : collection) {
//            arrayList.add(c.c());
//        }
//        return arrayList;
//    }
//}