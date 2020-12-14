package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: vY  reason: default package and case insensitive filesystem */
public class C4222vY {
//    private static final float[][] brd = {new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f}, new float[]{0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f}, new float[]{0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}};
//
//    public static Bitmap a(Bitmap bitmap, int i, float[] fArr) {
//        if (bitmap == null) {
//            return null;
//        }
//        if (i >= brd.length) {
//            i = 1;
//        }
//        if (i == 1 && fArr == null) {
//            return bitmap;
//        }
//        Matrix matrix = new Matrix();
//        matrix.setValues(brd[i]);
//        if (fArr != null) {
//            Matrix matrix2 = new Matrix();
//            matrix2.setValues(fArr);
//            matrix.postConcat(matrix2);
//        }
//        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//    }
//
//    public static int ab(float f) {
//        if (B612Application.De() == null) {
//            return 0;
//        }
//        return (int) ((f * B612Application.De().getResources().getDisplayMetrics().density) + 0.5f);
//    }
//
//    public static Rect b(int i, int i2, Rect rect) {
//        Rect rect2 = new Rect(rect);
//        int width = rect.width();
//        int height = rect.height();
//        if (i * height < width * i2) {
//            float f = (((float) width) - (((float) i) * (((float) height) / ((float) i2)))) * 0.5f;
//            rect2.left = (int) (((float) rect2.left) + f);
//            rect2.right = (int) (((float) rect2.right) - f);
//        } else {
//            float f2 = (((float) height) - (((float) i2) * (((float) width) / ((float) i)))) * 0.5f;
//            rect2.top = (int) (((float) rect2.top) + f2);
//            rect2.bottom = (int) (((float) rect2.bottom) - f2);
//        }
//        return rect2;
//    }
//
//    public static int bb(float f) {
//        return (int) TypedValue.applyDimension(2, f, B612Application.De().getResources().getDisplayMetrics());
//    }
//
//    public static int[] e(InputStream inputStream) {
//        int[] iArr = {0, 0};
//        if (inputStream != null) {
//            try {
//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inJustDecodeBounds = true;
//                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
//                int i = options.outWidth;
//                int i2 = options.outHeight;
//                if (i > 0 || i2 > 0) {
//                    iArr[0] = i;
//                    iArr[1] = i2;
//                }
//            } catch (Exception unused) {
//            }
//        }
//        return iArr;
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
//        if (r2 != null) goto L_0x001d;
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
//        if (r2 != null) goto L_0x001d;
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
//        r2.close();
//     */
//    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028 A[SYNTHETIC, Splitter:B:14:0x0028] */
//    public static Bitmap me(String str) {
//        Bitmap bitmap;
//        InputStream inputStream;
//        Throwable th;
//        if (StickerHelper.isAsset(str)) {
//            bitmap = null;
//            try {
//                inputStream = c.INSTANCE.context.getAssets().open(StickerHelper.getAssetPath(str));
//                try {
//                    bitmap = BitmapFactory.decodeStream(inputStream);
//                } catch (IOException unused) {
//                } catch (Throwable th2) {
//                    th = th2;
//                    if (inputStream != null) {
//                    }
//                    throw th;
//                }
//            } catch (IOException unused2) {
//                inputStream = null;
//            } catch (Throwable th3) {
//                th = th3;
//                inputStream = null;
//                if (inputStream != null) {
//                    try {
//                        inputStream.close();
//                    } catch (Exception unused3) {
//                    }
//                }
//                throw th;
//            }
//        } else {
//            Bitmap decodeFile = BitmapFactory.decodeFile(str);
//            if (decodeFile != null) {
//                return decodeFile;
//            }
//            return BitmapFactory.decodeFile(str + StickerHelper.TEX);
//        }
//        return bitmap;
//    }
//
//    public static int[] ne(String str) {
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(str, options);
//        return new int[]{options.outWidth, options.outHeight};
//    }
//
//    public static int[] oe(String str) {
//        int[] ne = ne(str);
//        int pe = pe(str);
//        if (!(pe == 5 || pe == 6 || pe == 7 || pe == 8)) {
//            return ne;
//        }
//        return new int[]{ne[1], ne[0]};
//    }
//
//    public static int pe(String str) {
//        try {
//            return new ExifInterface(str).getAttributeInt("Orientation", 0);
//        } catch (IOException unused) {
//            return 0;
//        }
//    }
//
    public static int qe(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
//
//    public static String r(Bitmap bitmap) {
//        if (bitmap == null) {
//            return "null bitmap";
//        }
//        StringBuilder la = Ff.la("");
//        la.append(bitmap.getWidth());
//        la.append("x");
//        la.append(bitmap.getHeight());
//        return la.toString();
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025 A[SYNTHETIC, Splitter:B:17:0x0025] */
//    /* JADX WARNING: Removed duplicated region for block: B:23:0x002b A[SYNTHETIC, Splitter:B:23:0x002b] */
//    public static int[] s(File file) {
//        int[] iArr = {0, 0};
//        if (file != null && file.isFile()) {
//            FileInputStream fileInputStream = null;
//            try {
//                FileInputStream fileInputStream2 = new FileInputStream(file);
//                try {
//                    iArr = e(fileInputStream2);
//                } catch (Exception unused) {
//                    fileInputStream = fileInputStream2;
//                    if (fileInputStream != null) {
//                    }
//                    return iArr;
//                } catch (Throwable th) {
//                    th = th;
//                    fileInputStream = fileInputStream2;
//                    if (fileInputStream != null) {
//                    }
//                    throw th;
//                }
//                try {
//                    fileInputStream2.close();
//                } catch (IOException unused2) {
//                }
//            } catch (Exception unused3) {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//                return iArr;
//            } catch (Throwable th2) {
//                th = th2;
//                if (fileInputStream != null) {
//                    try {
//                        fileInputStream.close();
//                    } catch (IOException unused4) {
//                    }
//                }
//                throw th;
//            }
//        }
//        return iArr;
//    }
//
//    public static int w(int i, int i2, int i3) {
//        if (i <= 0 || i2 <= 0) {
//            return 0;
//        }
//        return (int) Math.pow(2.0d, (double) ((int) Math.max(0.0d, Math.ceil(Math.log(((double) (i * i2)) / ((double) i3)) / Math.log(2.0d)))));
//    }
//
//    public static int x(int i, int i2, int i3) {
//        if (i3 <= 0) {
//            i3 = Math.max(a.bV(), a.aV());
//        }
//        int i4 = 1;
//        if (i > 0 && i2 > 0) {
//            while (true) {
//                if (i2 / i4 <= i3 && i / i4 <= i3) {
//                    break;
//                }
//                i4 *= 2;
//            }
//        }
//        return i4;
//    }
//
//    public static Bitmap a(File file, int i) {
//        Bitmap bitmap;
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
//        int x = x(options.outWidth, options.outHeight, i);
//        options.inJustDecodeBounds = false;
//        options.inSampleSize = Math.max(1, x / 2);
//        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
//        if (decodeFile == null) {
//            return null;
//        }
//        if (Math.max(decodeFile.getWidth(), decodeFile.getHeight()) > i) {
//            bitmap = C4359yU.d(decodeFile, i);
//            if (bitmap != decodeFile && !decodeFile.isRecycled()) {
//                decodeFile.recycle();
//            }
//        } else {
//            bitmap = decodeFile;
//        }
//        try {
//            Bitmap a = a(bitmap, pe(file.getAbsolutePath()), (float[]) null);
//            if (bitmap != a && !bitmap.isRecycled()) {
//                bitmap.recycle();
//            }
//            return a;
//        } catch (Throwable th) {
//            th.printStackTrace();
//            return decodeFile;
//        }
//    }
//
//    public static RectF b(int i, int i2, RectF rectF) {
//        RectF rectF2 = new RectF(rectF);
//        float width = rectF.width();
//        float height = rectF.height();
//        float f = (float) i;
//        float f2 = (float) i2;
//        if (f * height < width * f2) {
//            float f3 = (width - ((height / f2) * f)) * 0.5f;
//            rectF2.left += f3;
//            rectF2.right -= f3;
//        } else {
//            float f4 = (height - ((width / f) * f2)) * 0.5f;
//            rectF2.top += f4;
//            rectF2.bottom -= f4;
//        }
//        return rectF2;
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
//        if (r2 == null) goto L_0x004d;
//     */
//    public static String s(Uri uri) {
//        if (uri.toString().contains("file:/") || uri.toString().startsWith(Constants.URL_PATH_DELIMITER)) {
//            return uri.getPath();
//        }
//        String str = "";
//        Cursor cursor = null;
//        try {
//            cursor = B612Application.De().getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
//            if (cursor.moveToFirst()) {
//                str = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } catch (Throwable th) {
//            if (cursor != null) {
//                cursor.close();
//            }
//            throw th;
//        }
//        cursor.close();
//        return str;
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023 A[SYNTHETIC, Splitter:B:12:0x0023] */
//    /* JADX WARNING: Removed duplicated region for block: B:20:0x002a  */
//    /* JADX WARNING: Removed duplicated region for block: B:26:0x0032 A[SYNTHETIC, Splitter:B:26:0x0032] */
//    public static Bitmap a(File file, int i, boolean z) {
//        Bitmap bitmap;
//        FileInputStream fileInputStream;
//        int[] s = s(file);
//        int i2 = s[0];
//        int i3 = s[1];
//        float[] fArr = null;
//        if (file != null && true == file.isFile()) {
//            try {
//                fileInputStream = new FileInputStream(file);
//            } catch (Exception unused) {
//                fileInputStream = null;
//                if (fileInputStream != null) {
//                }
//                bitmap = null;
//                if (z) {
//                }
//                Bitmap a = a(bitmap, pe(file.getAbsolutePath()), fArr);
//                bitmap.recycle();
//                return a;
//            } catch (Throwable th) {
//                th = th;
//                fileInputStream = null;
//                if (fileInputStream != null) {
//                }
//                throw th;
//            }
//            try {
//                bitmap = a((InputStream) fileInputStream, i2, i3, i);
//            } catch (Exception unused2) {
//                if (fileInputStream != null) {
//                    bitmap = null;
//                    fileInputStream.close();
//                    if (z) {
//                    }
//                    Bitmap a2 = a(bitmap, pe(file.getAbsolutePath()), fArr);
//                    bitmap.recycle();
//                    return a2;
//                }
//                bitmap = null;
//                if (z) {
//                }
//                Bitmap a22 = a(bitmap, pe(file.getAbsolutePath()), fArr);
//                bitmap.recycle();
//                return a22;
//            } catch (Throwable th2) {
//                th = th2;
//                if (fileInputStream != null) {
//                    try {
//                        fileInputStream.close();
//                    } catch (IOException unused3) {
//                    }
//                }
//                throw th;
//            }
//            try {
//                fileInputStream.close();
//            } catch (IOException unused4) {
//            }
//            if (z) {
//                try {
//                    fArr = brd[4];
//                } catch (Throwable th3) {
//                    th3.printStackTrace();
//                    return bitmap;
//                }
//            }
//            Bitmap a222 = a(bitmap, pe(file.getAbsolutePath()), fArr);
//            if (!(bitmap == a222 || bitmap == null || bitmap.isRecycled())) {
//                bitmap.recycle();
//            }
//            return a222;
//        }
//        bitmap = null;
//        if (z) {
//        }
//        Bitmap a2222 = a(bitmap, pe(file.getAbsolutePath()), fArr);
//        bitmap.recycle();
//        return a2222;
//    }
//
//    public static Bitmap a(InputStream inputStream, int i, int i2, int i3) {
//        if (inputStream == null) {
//            return null;
//        }
//        int x = x(i, i2, i3);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inSampleSize = x;
//        options.inTempStorage = new byte[STMobileHumanActionNative.ST_MOBILE_ENABLE_BODY_CONTOUR];
//        options.inPurgeable = true;
//        try {
//            return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
//        } catch (OutOfMemoryError unused) {
//            return null;
//        }
//    }
//
//    public static int[] a(int i, int i2, int i3, int i4, C4031rV rVVar) {
//        int[] iArr = new int[2];
//        if (rVVar.yI % 180 != 0) {
//            float f = (float) i2;
//            float f2 = (float) i;
//            float min = Math.min(((float) i3) / f, ((float) i4) / f2);
//            iArr[0] = (int) (f * min);
//            iArr[1] = (int) (f2 * min);
//        } else {
//            float f3 = (float) i;
//            float f4 = (float) i2;
//            float min2 = Math.min(((float) i3) / f3, ((float) i4) / f4);
//            iArr[0] = (int) (f3 * min2);
//            iArr[1] = (int) (f4 * min2);
//        }
//        return iArr;
//    }
//
//    public static boolean a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, File file) throws IOException {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
//            boolean compress = bitmap.compress(compressFormat, i, fileOutputStream);
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (Throwable th) {
//                C1936XE.closeQuietly(fileOutputStream);
//                throw th;
//            }
//            C1936XE.closeQuietly(fileOutputStream);
//            return compress;
//        } catch (FileNotFoundException e2) {
//            throw e2;
//        }
//    }
//
//    public static Size a(AspectRatio aspectRatio, int i, int i2) {
//        int ordinal = aspectRatio.ordinal();
//        if (ordinal == 1) {
//            int i3 = i / 9;
//            int i4 = i2 / 16;
//            if (i3 > i4) {
//                i2 = i3 * 16;
//            } else {
//                i = i4 * 9;
//            }
//        } else if (ordinal == 2) {
//            int i5 = i / 3;
//            int i6 = i2 / 4;
//            if (i5 > i6) {
//                i2 = i5 * 4;
//            } else {
//                i = i6 * 3;
//            }
//        } else if (ordinal == 3) {
//            int max = Math.max(i, i2);
//            i2 = Math.max(i, i2);
//            i = max;
//        } else if (ordinal == 4) {
//            int i7 = i / 4;
//            int i8 = i2 / 3;
//            if (i7 > i8) {
//                i2 = i7 * 3;
//            } else {
//                i = i8 * 4;
//            }
//        } else if (ordinal == 5) {
//            int i9 = i / 16;
//            int i10 = i2 / 9;
//            if (i9 > i10) {
//                i2 = i9 * 9;
//            } else {
//                i = i10 * 16;
//            }
//        }
//        return new Size(i, i2);
//    }
//
//    public static Bitmap a(Bitmap bitmap, int i, int i2) {
//        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
//        Canvas canvas = new Canvas(createBitmap);
//        canvas.drawBitmap(bitmap, ((float) (canvas.getWidth() - bitmap.getWidth())) / 2.0f, ((float) (canvas.getHeight() - bitmap.getHeight())) / 2.0f, (Paint) null);
//        return createBitmap;
//    }
}