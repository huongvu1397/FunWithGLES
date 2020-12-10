package com.excalibur.funwithgles.sdmaidpro.model;

import android.os.Parcel;
import android.os.Parcelable;

public enum Location implements Parcelable {
    SDCARD("SDCARD"),
    PUBLIC_MEDIA("PUBLIC_MEDIA"),
    PUBLIC_DATA("PUBLIC_DATA"),
    PUBLIC_OBB("PUBLIC_OBB"),
    PRIVATE_DATA("PRIVATE_DATA"),
    APP_LIB("APP_LIB"),
    APP_ASEC("APP_ASEC"),
    MNT_SECURE_ASEC("MNT_SECURE_ASEC"),
    APP_APP("APP_APP"),
    APP_APP_PRIVATE("APP_APP_PRIVATE"),
    DALVIK_DEX("DALVIK_DEX"),
    DALVIK_PROFILE("DALVIK_PROFILE"),
    SYSTEM_APP("SYSTEM_APP"),
    SYSTEM_PRIV_APP("SYSTEM_PRIV_APP"),
    DOWNLOAD_CACHE("DOWNLOAD_CACHE"),
    SYSTEM("SYSTEM"),
    DATA("DATA"),
    DATA_SYSTEM("DATA_SYSTEM"),
    DATA_SYSTEM_CE("DATA_SYSTEM_CE"),
    DATA_SYSTEM_DE("DATA_SYSTEM_DE"),
    PORTABLE("PORTABLE"),
    ROOT("ROOT"),
    VENDOR("VENDOR"),
    OEM("OEM"),
    DATA_SDEXT2("DATA_SDEXT2"),
    UNKNOWN("UNKNOWN");
    
    public static Parcelable.Creator<Location> CREATOR = null;
    private final String mRaw;

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Parcelable.Creator<Location>() {
            public final /* bridge */ /* synthetic */ Location[] newArray(int i) {
                return new Location[i];
            }

            public final /* synthetic */ Location createFromParcel(Parcel parcel) {
                return Location.fromRaw(parcel.readString());
            }
        };
    }

    private Location(String str) {
        this.mRaw = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRaw);
    }

    public final String getRaw() {
        return this.mRaw;
    }

    public static Location fromRaw(String str) {
        for (Location location : values()) {
            if (location.getRaw().equals(str)) {
                return location;
            }
        }
        throw new IllegalArgumentException("Unknown location TAG: " + str);
    }
}