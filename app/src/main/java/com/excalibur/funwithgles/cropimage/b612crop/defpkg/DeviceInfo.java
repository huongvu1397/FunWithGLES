//package com.excalibur.funwithgles.cropimage.b612crop.defpkg;
//
//import android.content.Context;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//import android.content.pm.Signature;
//import android.media.MediaCodecInfo;
//import android.media.MediaCodecList;
//import android.os.Build;
//import android.os.Handler;
//import android.text.TextUtils;
//import com.appsflyer.share.Constants;
//import com.linecorp.b612.android.B612Application;
//import com.linecorp.b612.android.activity.activitymain._g;
//import com.linecorp.b612.android.activity.activitymain.sectionlist.SectionType;
//import com.linecorp.b612.android.activity.edit.photo.C2432g;
//import com.linecorp.kale.android.config.DebugProperty;
//import com.linecorp.kale.android.config.DeviceConfig;
//import com.linecorp.kale.android.config.d;
//import com.sensetime.stmobile.STMobileHumanActionNative;
//import java.io.RandomAccessFile;
//import java.util.Locale;
//
//public class DeviceInfo {
//    private static int Qld;
//    public static Kha<a> Rld = Kha.lb(a.LEVEL_UNKNOWN);
//    private static String Sld;
//    public static int Tld;
//    public static int Uld;
//    public static int Vld;
//    public static long Wld;
//    public static int Xld;
//    public static long Yld = 0;
//    public static boolean Zld = false;
//    public static volatile C2980w<b> _ld = new C2980w<>(C2962d.INSTANCE);
//    public static final String[] amd = {"OMX.qcom.video.decoder.avc", "OMX.k3.video.decoder.avc", "OMX.Exynos.avc.dec", "OMX.Nvidia.h264.decoder", "OMX.MTK.VIDEO.DECODER.AVC"};
//
//    public enum a {
//        LEVEL_UNKNOWN("u", 1.5f, C2432g.PHc, C2432g.PHc, 10, 648, DeviceConfig.SmoothType.LEGACY, false, 0),
//        LEVEL_C(Constants.URL_CAMPAIGN, 1.0f, 1280, 1280, 10, 648, DeviceConfig.SmoothType.LEGACY, false, 1),
//        LEVEL_B("b", 1.5f, C2432g.PHc, 1280, 15, 648, DeviceConfig.SmoothType.LEGACY, false, 2),
//        LEVEL_A("a", 2.0f, STMobileHumanActionNative.ST_MOBILE_ENABLE_BODY_KEYPOINTS, C2432g.PHc, 20, 720, DeviceConfig.SmoothType.MEAN_VAR, false, 3),
//        LEVEL_S("s", 3.0f, STMobileHumanActionNative.ST_MOBILE_ENABLE_BODY_KEYPOINTS, C2432g.PHc, 30, 720, DeviceConfig.SmoothType.MEAN_VAR, true, 4);
//
//        public final String code;
//        public final int kVc;
//        public final int kuruValue;
//        public final float rUd;
//        public final int sUd;
//        public final DeviceConfig.SmoothType smoothType;
//        public final int tUd;
//        public final int uUd;
//        public final boolean usePBOSyncMode;
//
//        private a(String str, float f, int i, int i2, int i3, int i4, DeviceConfig.SmoothType smoothType2, boolean z, int i5) {
//            this.code = str;
//            this.rUd = f;
//            this.sUd = i;
//            this.tUd = i2;
//            this.kVc = i3;
//            this.uUd = i4;
//            this.smoothType = smoothType2;
//            this.usePBOSyncMode = z;
//            this.kuruValue = i5;
//        }
//
//        public boolean mja() {
//            return this == LEVEL_S || this == LEVEL_A || this == LEVEL_B;
//        }
//
//        public boolean nja() {
//            return this == LEVEL_B || this == LEVEL_C || this == LEVEL_UNKNOWN;
//        }
//
//        public boolean oja() {
//            return this == LEVEL_S;
//        }
//
//        public boolean pja() {
//            return this == LEVEL_A || this == LEVEL_S;
//        }
//
//        public boolean qja() {
//            return this == LEVEL_UNKNOWN;
//        }
//    }
//
//    public enum b {
//        HW_DECODER,
//        SW_DECODER
//    }
//
//    static {
//        new C2980w(C2961c.INSTANCE);
//    }
//
//    public static void Jj(int i) {
//        Qld = i;
//        C3968qF.v("maxTextureSize", i);
//    }
//
//    public static long Tca() {
//        String str = "";
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
//            String readLine = randomAccessFile.readLine();
//            randomAccessFile.close();
//            for (int i = 0; i < readLine.length(); i++) {
//                char charAt = readLine.charAt(i);
//                if ('0' <= charAt && '9' >= charAt) {
//                    str = str + charAt;
//                }
//            }
//        } catch (Throwable th) {
//            th.printStackTrace();
//        }
//        try {
//            return Long.parseLong(str);
//        } catch (Throwable unused) {
//            return 0;
//        }
//    }
//
//    public static String Uca() {
//        return Sld;
//    }
//
//    public static int Vca() {
//        int i = Qld;
//        return i == 0 ? C3968qF.u("maxTextureSize", 0) : i;
//    }
//
//    public static int Wca() {
//        if (TextUtils.isEmpty(Build.FINGERPRINT)) {
//            return Build.VERSION.SDK_INT;
//        }
//        return (Build.FINGERPRINT + Build.VERSION.SDK_INT).hashCode();
//    }
//
//    public static void Wd(String str) {
//        Sld = str;
//    }
//
//    public static String Xca() {
//        Signature[] signatureArr;
//        Context De = B612Application.De();
//        StringBuilder sb = new StringBuilder(10);
//        try {
//            PackageInfo packageInfo = De.getPackageManager().getPackageInfo(De.getPackageName(), 64);
//            if (!(packageInfo == null || (signatureArr = packageInfo.signatures) == null)) {
//                if (signatureArr.length != 0) {
//                    for (int i = 0; i < packageInfo.signatures.length; i++) {
//                        if (i != 0) {
//                            sb.append(", ");
//                        }
//                        Signature signature = packageInfo.signatures[i];
//                        if (signature != null) {
//                            C1531IE.d("Signature : found=" + signature.hashCode(), new Object[0]);
//                            sb.append(signature.hashCode());
//                        }
//                    }
//                    return sb.toString();
//                }
//            }
//            C1531IE.d("Signature : Failed to get one or not exist", new Object[0]);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return sb.toString();
//    }
//
//    public static String Yca() {
//        int codecCount = MediaCodecList.getCodecCount();
//        for (int i = 0; i < codecCount; i++) {
//            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
//            if (!codecInfoAt.isEncoder()) {
//                for (String equals : codecInfoAt.getSupportedTypes()) {
//                    if (equals.equals("video/avc")) {
//                        return codecInfoAt.getName();
//                    }
//                }
//                continue;
//            }
//        }
//        return "";
//    }
//
//    public static boolean Zca() {
//        return C1412DU.GalaxyNexus.match();
//    }
//
//    public static boolean _ca() {
//        return Build.MODEL.matches("(?i)(ZenFone 5|ZE620KL|ZS620KL).*");
//    }
//
//    static /* synthetic */ void a(Handler handler, Pca pca) {
//        try {
//            com.linecorp.b612.android.base.util.b bVar = new com.linecorp.b612.android.base.util.b(d.grd);
//            int i = Qld;
//            int i2 = 4;
//            Tld = 2048 > i ? 1 : 4096 > i ? 2 : 8192 > i ? 3 : 4;
//            Uld = yBa();
//            Xld = Runtime.getRuntime().availableProcessors();
//            int i3 = Xld;
//            if (1 >= i3) {
//                i2 = 1;
//            } else if (4 > i3) {
//                i2 = 2;
//            }
//            Vld = i2;
//            int min = Math.min(Math.min(Tld, Vld), Uld);
//            Yld = Tca();
//            if (2 == min && 2000000 < Yld) {
//                min = 3;
//            }
//            a aVar = a.values()[min];
//            Rld.t(aVar);
//            C1639ME.sendClick("bas", "deviceleveldub", aVar.code);
//            bVar.jd("update device level");
//            handler.post(new C2960b(pca, aVar));
//            C1639ME.sendClick("bas", "abi", Build.CPU_ABI);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static boolean ada() {
//        return C1412DU.OppoR9m.match() || C1412DU.OppoR9s.match() || C1412DU.GalaxyJ7.match() || C1412DU.GalaxyJ7_2016.match();
//    }
//
//    public static boolean bda() {
//        return Build.MODEL.matches("(?i)(EML-L09|EML-L09C|EML-L29|EML-AL00).*");
//    }
//
//    public static boolean c(a aVar) {
//        if (aVar.pja() && !DebugProperty.INSTANCE.forceLutForWhiteMode) {
//            if (C1412DU.GalaxyGrandPrime.match() || C1412DU.GalaxyCorePrime.match() || C1412DU.GalaxyXcover3.match() || C1412DU.GalaxyJ1Ace.match()) {
//                return true;
//            }
//            return false;
//        }
//        return true;
//    }
//
//    public static boolean cda() {
//        return Build.MODEL.matches("(?i)(ANE-AL00|ANE-TL00|ALE-LX1).*");
//    }
//
//    public static boolean dda() {
//        return Build.MODEL.matches("(?i)(CLT-L04|CLT-L09|CLT-L09C|CLT-L29|CLT-L29C|CLT-AL00|CLT-AL01).*");
//    }
//
//    public static boolean eda() {
//        return Build.BRAND.matches("(?i)(lenovo).*") && Build.MODEL.matches("(?i)(Z5).*");
//    }
//
//    public static boolean fda() {
//        return Build.MODEL.matches("(?i)(A6000|A6003).*");
//    }
//
//    public static boolean gda() {
//        return Build.MANUFACTURER.matches("(?i)(OPPO).*") && Build.MODEL.matches("(?i)(A3|F7|CPH1819).*");
//    }
//
//    public static a getDeviceLevel() {
//        return Rld.getValue();
//    }
//
//    public static int getDeviceLevelKuruValue() {
//        return Rld.getValue().kuruValue;
//    }
//
//    public static boolean hda() {
//        return C1412DU.VivoY67A.match();
//    }
//
//    public static boolean ida() {
//        String str = Sld;
//        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.US).contains("powervr");
//    }
//
//    public static boolean jda() {
//        return Build.MODEL.matches("(?i)(SM-F900U).*");
//    }
//
//    public static boolean kda() {
//        return ((C2976s.Qca().lja() && getDeviceLevel().pja()) || (C2976s.Qca().kja() && getDeviceLevel().oja())) && !"ASUS_Z01FD".equals(Build.MODEL);
//    }
//
//    public static boolean lda() {
//        return Build.MODEL.matches("(?i)(vivo X21A).*");
//    }
//
//    public static boolean mda() {
//        return Build.MODEL.matches("(?i)(Mi8|Mi8 SE|Mi8 Explorer).*");
//    }
//
//    public static boolean nda() {
//        return C1412DU.XperiaXZ.match();
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
//        if (defpackage.C1412DU.Nexus9.match() == false) goto L_0x00e8;
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
//        if (defpackage.C1412DU.GalaxyS6Edge.match() == false) goto L_0x00e8;
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e5, code lost:
//        if (defpackage.C1412DU.HtcOneM8.match() == false) goto L_0x00e8;
//     */
//    /* JADX WARNING: Removed duplicated region for block: B:69:0x00eb A[SYNTHETIC] */
//    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ee A[SYNTHETIC] */
//    static /* synthetic */ b oda() {
//        String Yca = Yca();
//        if (Yca.equals("OMX.google.h264.decoder")) {
//            return b.SW_DECODER;
//        }
//        if (!Zld) {
//            return b.HW_DECODER;
//        }
//        int i = 0;
//        while (true) {
//            String[] strArr = amd;
//            if (i >= strArr.length) {
//                return b.SW_DECODER;
//            }
//            if (Yca.equals(strArr[i])) {
//                boolean z = true;
//                if (i == 0) {
//                    if (!C1412DU.GalaxyS5.match()) {
//                        if (!C1412DU.OptimusG.match()) {
//                            if (!C1412DU.OptimusGPro.match()) {
//                                if (!C1412DU.LGGPro2.match()) {
//                                    if (!C1412DU.LGG2.match()) {
//                                        if (!C1412DU.LGG3.match()) {
//                                            if (!C1412DU.LGG3Cat6.match()) {
//                                                if (!C1412DU.LGL70.match()) {
//                                                    if (!C1412DU.VegaNumber6.match()) {
//                                                        if (!C1412DU.XperiaZ1.match()) {
//                                                            if (!C1412DU.XperiaZ1f.match()) {
//                                                                if (!C1412DU.OppoN1Mini.match()) {
//                                                                    if (!C1412DU.OppoN3.match()) {
//                                                                        if (!C1412DU.OppoN7.match()) {
//                                                                            if (!C1412DU.Nexus5.match()) {
//                                                                                if (!C1412DU.Nexus7.match()) {
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    if (z) {
//                    }
//                } else if (i != 1) {
//                    if (i == 2) {
//                        if (!C1412DU.GalaxyS6.match()) {
//                        }
//                        if (z) {
//                        }
//                    } else if (i == 3) {
//                        if (!C1412DU.Nexus7.match()) {
//                        }
//                        if (z) {
//                        }
//                    } else if (i == 4) {
//                        z = C1412DU.NECLaviePCTE508S1.match();
//                        if (z) {
//                            return b.HW_DECODER;
//                        }
//                    }
//                }
//                z = false;
//                if (z) {
//                }
//            }
//            i++;
//        }
//    }
//
//    public static long pda() {
//        return 5038847;
//    }
//
//    public static boolean qda() {
//        return Build.MANUFACTURER.matches("(?i)(HUAWEI).*");
//    }
//
//    public static void te(boolean z) {
//        Zld = z;
//        _ld = new C2980w<>(C2962d.INSTANCE);
//    }
//
//    private static int yBa() {
//        long j;
//        String str = "";
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
//            String readLine = randomAccessFile.readLine();
//            randomAccessFile.close();
//            for (int i = 0; i < readLine.length(); i++) {
//                char charAt = readLine.charAt(i);
//                if ('0' <= charAt && '9' >= charAt) {
//                    str = str + charAt;
//                }
//            }
//        } catch (Throwable th) {
//            th.printStackTrace();
//        }
//        try {
//            j = Long.parseLong(str);
//        } catch (Throwable unused) {
//            j = 0;
//        }
//        Wld = j;
//        long j2 = Wld;
//        if (1400000 > j2) {
//            return 1;
//        }
//        if (2000000 > j2) {
//            return 2;
//        }
//        return 3000000 > j2 ? 3 : 4;
//    }
//
//    static /* synthetic */ void a(Pca pca, a aVar) {
//        try {
//            pca.accept(aVar);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static C4078sV a(SectionType sectionType, _g _gVar) {
//        if (C1412DU.MotorolaMotoX.match()) {
//            return C4078sV.FFMPEG;
//        }
//        if (sectionType.photoNum() != 1 || _gVar.zsc.getValue().booleanValue()) {
//            return C4078sV.MEDIA_CODEC_WITH_FFMPEG;
//        }
//        return C4078sV.MEDIA_CODEC;
//    }
//}