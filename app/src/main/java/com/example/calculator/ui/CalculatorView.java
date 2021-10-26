package com.example.calculator.ui;

import com.example.calculator.domain.Theme;

import java.util.List;

public interface CalculatorView {

    void showResult(String result);

    void showThemes(List<Theme> themes);
}
