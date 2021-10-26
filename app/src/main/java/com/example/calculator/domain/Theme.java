package com.example.calculator.domain;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator.R;

public enum Theme {

    THEME_ONE(R.string.theme_one, R.drawable.ic_baseline_wb_sunny_24, R.style.Theme_Calculator);

    private String key;

    private Theme(int theme_one, int title, int img) {
        this.title = title;
        this.img = img;
        this.theme = theme;
    }

    public int getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public int getTheme() {
        return theme;
    }

    @StringRes
    private int title;
    @DrawableRes
    private int img;
    @StyleRes
    private int theme;

    public String getKey() {
        return key;
    }
}
