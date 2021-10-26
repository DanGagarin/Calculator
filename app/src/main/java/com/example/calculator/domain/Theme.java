package com.example.calculator.domain;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Theme {
    @StringRes
    private int title;
    @DrawableRes
    private int img;

    public Theme(int title, int img){
        this.title = title;
        this.img = img;
    }

    public int getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public int getTheme() {
        return 0;
    }
}
