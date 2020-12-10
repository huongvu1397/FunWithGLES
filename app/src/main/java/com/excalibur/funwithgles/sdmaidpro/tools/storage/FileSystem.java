package com.excalibur.funwithgles.sdmaidpro.tools.storage;

/* compiled from: FileSystem */
public enum FileSystem {
    UNKNOWN(""),
    F2FS("f2fs"),
    EXT4("ext4"),
    TMPFS("tmpfs"),
    FUSE("fuse"),
    EXT3("ext3"),
    EXT2("ext2"),
    FAT32("fat32"),
    FAT16("fat16"),
    ROOTFS("rootfs"),
    PROC("proc"),
    SYSFS("sysfs"),
    CGROUP("cgroup"),
    YAFFS2("yaffs2"),
    VFAT("vfat"),
    HWVEFS("hwvefs"),
    RFS("rfs"),
    DEBUGFS("debugfs"),
    J4FS("j4fs"),
    DEVPTS("devpts"),
    SDCARDFS("sdcardfs"),
    ESDFS("esdfs"),
    ENCRYPTFS("ecryptfs");
    
    public final String x;

    private FileSystem(String str) {
        this.x = str;
    }
}