package com.excalibur.funwithgles.slideshow.edit;

public class Image {
    private String name;
    private String path;
    private int position = -1;

    public Image(String str, String str2) {
        this.name = str;
        this.path = str2;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }
}