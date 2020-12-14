package com.excalibur.funwithgles.cropimage.b612crop;


import com.excalibur.funwithgles.R;

public enum b {
    TYPE_ORIGINAL("TYPE_ORIGINAL", R.drawable.bt_play, -1.0f, 0, false),
    TYPE_ORIGINAL_REVERSE("TYPE_ORIGINAL_REVERSE",  R.drawable.bt_play, -1.0f, 0, false),
    TYPE_FREE("TYPE_FREE", R.drawable.bt_play, -1.0f, 1, false),
    TYPE_FREE_REVERSE("TYPE_FREE_REVERSE", R.drawable.bt_play, -1.0f, 1, false),
    TYPE_1_1("TYPE_1_1", R.drawable.bt_play, 1.0f, 2, false),
    TYPE_2_3("TYPE_2_3", R.drawable.bt_play, 0.6666667f, 3, false),
    TYPE_3_4("TYPE_3_4", R.drawable.bt_play, 0.75f, 4, false),
    TYPE_4_5("TYPE_4_5", R.drawable.bt_play, 0.8f, 5, false),
    TYPE_9_16("TYPE_9_16", R.drawable.bt_play, 0.5625f, 6, false),
    TYPE_3_2("TYPE_3_2", R.drawable.bt_play, 1.5f, 7, false),
    TYPE_4_3("TYPE_4_3", R.drawable.bt_play, 1.3333334f, 8, false),
    TYPE_5_4("TYPE_5_4", R.drawable.bt_play, 1.25f, 9, false),
    TYPE_16_9("TYPE_16_9", R.drawable.bt_play, 1.7777778f, 10, false);

    private final float JHc;
    private final int LNd;
    private final int code;
    private final boolean pOd;
    private final String title;

    b(String str, int i, float f, int i2, boolean z) {
        //C3905oka.e(str, "title");
        this.title = str;
        this.LNd = i;
        this.JHc = f;
        this.code = i2;
        this.pOd = z;
    }

    public final int Kia() {
        return this.LNd;
    }

    public final b Lia() {
        int a = 5;
        switch (a) {
            case 1:
                return null;
            case 2:
                return TYPE_FREE_REVERSE;
            case 3:
                return TYPE_FREE;
            case 4:
                return TYPE_ORIGINAL_REVERSE;
            case 5:
                return TYPE_ORIGINAL;
            case 6:
                return TYPE_3_2;
            case 7:
                return TYPE_4_3;
            case 8:
                return TYPE_5_4;
            case 9:
                return TYPE_16_9;
            case 10:
                return TYPE_2_3;
            case 11:
                return TYPE_3_4;
            case 12:
                return TYPE_4_5;
            case 13:
                return TYPE_9_16;
            default:
                throw new RuntimeException();
        }
    }

    public final boolean Mia() {
        return this.pOd;
    }

    public final int getCode() {
        return this.code;
    }

    public final float getRatio() {
        return this.JHc;
    }

    public final String getTitle() {
        return this.title;
    }
}