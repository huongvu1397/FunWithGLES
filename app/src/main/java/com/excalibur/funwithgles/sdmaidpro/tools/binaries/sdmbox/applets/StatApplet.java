//package com.excalibur.funwithgles.sdmaidpro.tools.binaries.sdmbox.applets;
//
//import com.excalibur.funwithgles.sdmaidpro.tools.binaries.core.a;
//
//import java.io.File;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Locale;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public interface StatApplet extends a {
//
//    /* renamed from: a  reason: collision with root package name */
//    public static final Collection<a> f3628a = new HashSet(Arrays.asList(new a[]{a.FILE, a.DIRECTORY, a.EMPTY_FILE, a.SYMBOLIC_LINK, a.FIFO}));
//
//    /* renamed from: b  reason: collision with root package name */
//    public static final List<b> f3629b = Arrays.asList(new b[]{b.ACCESS_BITS_OCT, b.FILE_TYPE, b.DEVICE_ID_DEC, b.INODE, b.USER_ID, b.GROUP_ID, b.SIZE_BYTES, b.BLOCK_BYTES, b.BLOCKS_ALLOC, b.MODIFICATION_STAMP, b.PATH});
//
//    public enum a {
//        EMPTY_FILE,
//        FILE,
//        DIRECTORY,
//        SYMBOLIC_LINK,
//        FIFO,
//        SOCKET,
//        CHARACTER_DEVICE,
//        BLOCK_DEVICE
//    }
//
//    eu.thedarken.sdm.tools.io.shell.a a(String str);
//
//    String m_();
//
//    public enum c {
//        ;
//
//
//        /* renamed from: a  reason: collision with root package name */
//        public static final int f3635a = 1;
//
//        /* renamed from: b  reason: collision with root package name */
//        public static final int f3636b = 2;
//
//        static {
//            //c = new int[]{f3635a, f3636b};
//        }
//    }
//
//    public enum b {
//        ACCESS_BITS_OCT("%a"),
//        FILE_TYPE("%F"),
//        DEVICE_ID_DEC("%d"),
//        INODE("%i"),
//        USER_ID("%u"),
//        GROUP_ID("%g"),
//        SIZE_BYTES("%s"),
//        BLOCK_BYTES("%B"),
//        BLOCKS_ALLOC("%b"),
//        MODIFICATION_STAMP("%Y"),
//        PATH("%N");
//
//        final String l;
//
//        private b(String str) {
//            this.l = str;
//        }
//    }
//
//    public static class Factory extends a<eu.thedarken.sdm.tools.binaries.sdmbox.a> {
//
//        /* renamed from: b  reason: collision with root package name */
//        static final String f3630b = (eu.thedarken.sdm.tools.binaries.sdmbox.a.d + "Stat:Factory");
//        static final Pattern c = Pattern.compile("^([0-9]+)(?:[:])([\\w\\(\\) ]+?)(?:[:])([0-9]+d?)(?:[:])([0-9]+)(?:[:])([0-9]+)(?:[:])([0-9]+)(?:[:])([0-9]+)(?:[:])([0-9]+)(?:[:])([0-9]+)(?:[:])([0-9]+)(?:[:])([\\W\\w]*?)$");
//        static final Pattern d = Pattern.compile("^(?:')([\\W\\w]*?)(?:')(?:(?:\\s->\\s')([\\W\\w]*?)(?:'))?$");
//        static final Pattern e = Pattern.compile("^(?:`)([\\W\\w]*?)(?:')(?:(?:\\s->\\s`)([\\W\\w]*?)(?:'))?$");
//        static final Pattern f = Pattern.compile("^(?:`)([\\W\\w]*?)(?:')$");
//        static final Pattern g = Pattern.compile("^([\\W\\w]*?)$");
//        static final String h = new File("/").getAbsolutePath();
//
//        public final String toString() {
//            return "Stat:Factory";
//        }
//
//        public Factory(SDMContext sDMContext) {
//            super(sDMContext);
//        }
//
//        /* JADX WARNING: Removed duplicated region for block: B:12:0x0080  */
//        /* JADX WARNING: Removed duplicated region for block: B:26:0x00f8 A[RETURN] */
//        /* JADX WARNING: Removed duplicated region for block: B:27:0x00f9  */
//        public final eu.thedarken.sdm.tools.binaries.core.a a(eu.thedarken.sdm.tools.binaries.core.b bVar, ab.b bVar2, ab.b bVar3) {
//            j jVar;
//            String a2 = bVar.a("stat");
//            int i = c.f3635a;
//            a.b a3 = eu.darken.a.a.a.a(a2 + " -c \"" + Instance.a(StatApplet.f3629b) + "\" " + this.f3641a.c.k().c()).a(bVar2);
//            if (a3.f1941a == 0 && a3.f1942b.size() == 1) {
//                Matcher matcher = c.matcher(a3.f1942b.get(0));
//                if (matcher.matches()) {
//                    if (f.matcher(matcher.group(11)).matches()) {
//                        i = c.f3636b;
//                    }
//                    jVar = j.USER;
//                    if (bVar3 != null) {
//                        p pVar = this.f3641a.c;
//                        a.b a4 = eu.darken.a.a.a.a(a2 + " -c \"" + Instance.a(StatApplet.f3629b) + "\" " + p.b().c()).a(bVar3);
//                        if (a4.f1941a == 0 && a4.f1942b.size() == 1) {
//                            Matcher matcher2 = c.matcher(a4.f1942b.get(0));
//                            if (matcher2.matches()) {
//                                if (f.matcher(matcher2.group(11)).matches()) {
//                                    i = c.f3636b;
//                                }
//                                jVar = jVar == j.USER ? j.ALL : j.ROOT;
//                            }
//                        }
//                    }
//                    if (jVar != null) {
//                        return null;
//                    }
//                    return new Instance(bVar, "stat", jVar, i);
//                }
//            }
//            jVar = null;
//            if (bVar3 != null) {
//            }
//            if (jVar != null) {
//            }
//        }
//
//        public static class Instance extends ExecutableApplet implements StatApplet {
//            private final int c;
//
//            public Instance(eu.thedarken.sdm.tools.binaries.core.b bVar, String str, j jVar, int i) {
//                super(bVar, str, jVar);
//                this.c = i;
//            }
//
//            static String a(List<b> list) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < list.size(); i++) {
//                    sb.append(list.get(i).l);
//                    if (i < list.size() - 1) {
//                        sb.append(":");
//                    }
//                }
//                return sb.toString();
//            }
//
//            public final String m_() {
//                List list = f3629b;
//                return new StringBuilder(b() + " -c \"" + a((List<b>) list) + "\"").toString();
//            }
//
//            public final eu.thedarken.sdm.tools.io.shell.a a(String str) {
//                boolean z = true;
//                try {
//                    eu.thedarken.sdm.tools.io.shell.a a2 = Factory.a(str, this.c);
//                    if (StatApplet.f3628a.contains(a2.f3850b)) {
//                        return a2;
//                    }
//                    b.a.a.b(Factory.f3630b).d("Unsupported filetype (for now) %s @ %s", a2.f3850b, a2.c.getPath());
//                    return null;
//                } catch (Exception e) {
//                    if (l.f2949a.h == null) {
//                        z = false;
//                    }
//                    if (!z) {
//                        return null;
//                    }
//                    eu.thedarken.sdm.tools.b.a(Factory.f3630b, new IllegalShellFileException(str, e));
//                    return null;
//                }
//            }
//        }
//
//        /* JADX WARNING: Can't fix incorrect switch cases order */
//        public static eu.thedarken.sdm.tools.io.shell.a a(String str, int i) {
//            char c2;
//            a aVar;
//            Integer valueOf;
//            Integer num;
//            Integer num2;
//            Date date;
//            String str2;
//            int i2;
//            String str3;
//            i iVar;
//            Matcher matcher;
//            Matcher matcher2;
//            int i3 = i;
//            Matcher matcher3 = c.matcher(str);
//            if (!matcher3.matches()) {
//                throw new IllegalArgumentException("Base stat output pattern doesn't match");
//            }
//            String group = matcher3.group(1);
//            String group2 = matcher3.group(2);
//            String group3 = matcher3.group(3);
//            String group4 = matcher3.group(4);
//            String group5 = matcher3.group(5);
//            String group6 = matcher3.group(6);
//            String group7 = matcher3.group(7);
//            String group8 = matcher3.group(8);
//            String group9 = matcher3.group(9);
//            String group10 = matcher3.group(10);
//            String group11 = matcher3.group(11);
//            Integer valueOf2 = Integer.valueOf(Integer.parseInt(group));
//            String lowerCase = group2.toLowerCase(Locale.US);
//            switch (lowerCase.hashCode()) {
//                case -1623439501:
//                    if (lowerCase.equals("regular empty file")) {
//                        c2 = 1;
//                        break;
//                    }
//                case -1122240183:
//                    if (lowerCase.equals("block device")) {
//                        c2 = 8;
//                        break;
//                    }
//                case -965829843:
//                    if (lowerCase.equals("character device")) {
//                        c2 = 7;
//                        break;
//                    }
//                case -962584979:
//                    if (lowerCase.equals("directory")) {
//                        c2 = 0;
//                        break;
//                    }
//                case -897048717:
//                    if (lowerCase.equals("socket")) {
//                        c2 = 4;
//                        break;
//                    }
//                case -622844032:
//                    if (lowerCase.equals("regular file")) {
//                        c2 = 3;
//                        break;
//                    }
//                case -147558848:
//                    if (lowerCase.equals("fifo (named pipe)")) {
//                        c2 = 6;
//                        break;
//                    }
//                case 3142860:
//                    if (lowerCase.equals("fifo")) {
//                        c2 = 5;
//                        break;
//                    }
//                case 726614696:
//                    if (lowerCase.equals("symbolic link")) {
//                        c2 = 2;
//                        break;
//                    }
//                default:
//                    c2 = 65535;
//                    break;
//            }
//            switch (c2) {
//                case 0:
//                    aVar = a.DIRECTORY;
//                    break;
//                case 1:
//                    aVar = a.EMPTY_FILE;
//                    break;
//                case 2:
//                    aVar = a.SYMBOLIC_LINK;
//                    break;
//                case 3:
//                    aVar = a.FILE;
//                    break;
//                case 4:
//                    aVar = a.SOCKET;
//                    break;
//                case 5:
//                    aVar = a.FIFO;
//                    break;
//                case 6:
//                    aVar = a.FIFO;
//                    break;
//                case 7:
//                    aVar = a.CHARACTER_DEVICE;
//                    break;
//                case 8:
//                    aVar = a.BLOCK_DEVICE;
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unknown file type");
//            }
//            if (group3.endsWith("d")) {
//                valueOf = Integer.valueOf(Integer.parseInt(group3.substring(0, group3.length() - 1)));
//            } else {
//                valueOf = Integer.valueOf(Integer.parseInt(group3));
//            }
//            Integer num3 = valueOf2;
//            Long valueOf3 = Long.valueOf(Long.parseLong(group4));
//            try {
//                num = Integer.valueOf(Integer.parseInt(group5));
//            } catch (NumberFormatException e2) {
//                //b.a.a.b(e2, "Invalid user id.", new Object[0]);
//                num = -1;
//            }
//            try {
//                num2 = Integer.valueOf(Integer.parseInt(group6));
//            } catch (NumberFormatException e3) {
//                //b.a.a.b(e3, "Invalid group id.", new Object[0]);
//                num2 = -1;
//            }
//            Long valueOf4 = Long.valueOf(Long.parseLong(group7));
//            Integer valueOf5 = Integer.valueOf(Integer.parseInt(group8));
//            Long valueOf6 = Long.valueOf(Long.parseLong(group9));
//            try {
//                date = new Date(Long.parseLong(group10) * 1000);
//            } catch (NumberFormatException e4) {
//                //b.a.a.b(f3630b).d(e4, "Invalid last modification time.", new Object[0]);
//                date = new Date(60000);
//            }
//            Date date2 = date;
//            if (aVar == a.SYMBOLIC_LINK) {
//                if (i3 == c.f3636b) {
//                    matcher2 = e.matcher(group11);
//                } else {
//                    matcher2 = d.matcher(group11);
//                }
//                if (matcher2.matches()) {
//                    str2 = matcher2.group(1);
//                    str3 = matcher2.group(2);
//                    i2 = 1;
//                } else {
//                    throw new IllegalArgumentException("Can't match symbolic link");
//                }
//            } else {
//                if (i3 == c.f3636b) {
//                    matcher = f.matcher(group11);
//                } else {
//                    matcher = g.matcher(group11);
//                }
//                if (matcher.matches()) {
//                    i2 = 1;
//                    str2 = matcher.group(1);
//                    str3 = null;
//                } else {
//                    throw new IllegalArgumentException("Can't match path");
//                }
//            }
//            if (str2.length() <= i2 || (str2.charAt(str2.length() - i2) != File.separatorChar && str2.startsWith(h))) {
//                File file = new File(str2);
//                if (aVar != a.SYMBOLIC_LINK || str3 == null) {
//                    iVar = i.a(file, new String[0]);
//                } else if (!str3.startsWith(h)) {
//                    iVar = i.a(file.getParent() + File.separator + str3);
//                } else {
//                    iVar = i.a(str3);
//                }
//                return new eu.thedarken.sdm.tools.io.shell.a(num3.intValue(), aVar, valueOf.intValue(), valueOf3.longValue(), num.intValue(), num2.intValue(), valueOf4.longValue(), valueOf5.intValue(), valueOf6.longValue(), date2, file, iVar);
//            }
//            throw new IllegalArgumentException("File path isn't absolute");
//        }
//    }
//}