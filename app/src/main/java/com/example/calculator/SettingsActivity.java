package com.example.calculator;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            logLifecycle("onCreate for the first time");

        } else {

            logLifecycle("onCreate for the next times");
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        logLifecycle("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        logLifecycle("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        logLifecycle("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        logLifecycle("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        logLifecycle("onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        logLifecycle("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        logLifecycle("onDestroy");
    }

    private void logLifecycle(String method) {
        Log.d("LifecycleMain", method + " " + this);
    }
}
