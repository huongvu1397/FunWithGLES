package com.excalibur.funwithgles.slideshow;

public interface RendererListener {
    void dismissDialog();

    void loadedAllImage();

    void loadingImage(int i);

    void previewComplete();

    void updateSeekBarTime(int i);
}