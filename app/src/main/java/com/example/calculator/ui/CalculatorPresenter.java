package com.example.calculator.ui;

import com.example.calculator.R;
import com.example.calculator.domain.Calculator;
import com.example.calculator.domain.Operation;
import com.example.calculator.domain.Theme;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPresenter {

    private static final int BASE = 10;

    private final CalculatorView view;
    private final Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private Operation previousOperation;

    private boolean isDotPressed;

    private int divider;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (argTwo == null) {

            if (isDotPressed) {
                argOne = argOne + digit / (double) divider;
                divider *= BASE;
            } else {
                argOne = argOne * BASE + digit;
            }
            displayResult(argOne);
        } else {
            if (isDotPressed) {
                argTwo = argTwo + digit / (double) divider;
                divider *= BASE;
            } else {
                argTwo = argTwo * BASE + digit;
            }
            displayResult(argTwo);
        }
    }

    public void onOperationPressed(Operation operation) {

        if (previousOperation != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);

            displayResult(result);

            argOne = result;

        }
        previousOperation = operation;
        argTwo = 0.0;

        isDotPressed = false;
    }

    public void onDotPressed() {
        if (!isDotPressed) {
            isDotPressed = true;
            divider = BASE;

        }
    }

    public void requestThemes(){
        List<Theme> themes = new ArrayList<>();
        themes.add(new Theme(R.string.theme_one, R.drawable.ic_baseline_wb_sunny_24));
        themes.add(new Theme(R.string.theme_two, R.drawable.ic_baseline_nights_stay_24));
        view.showThemes(themes);
    }

    public void displayResult(double arg) {

        long longValue = (long) arg;

        if (longValue == arg) {
            view.showResult(String.valueOf(longValue));
        } else {
            view.showResult(String.valueOf(arg));
        }
    }
}
