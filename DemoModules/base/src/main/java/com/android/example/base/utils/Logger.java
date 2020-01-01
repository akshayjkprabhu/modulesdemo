package com.android.example.base.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.android.example.base.BuildConfig;

public class Logger {

    private static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    public static void d(@NonNull String tag, String message) {
        if (isDebug()) {
            Log.d(tag, message);
        }
    }

    public static void w(@NonNull String tag, String message) {
        if (isDebug()) {
            Log.w(tag, message);
        }
    }

    public static void i(@NonNull String tag, String message) {
        if (isDebug()) {
            Log.i(tag, message);
        }
    }

    public static void e(@NonNull String tag, String message) {
        if (isDebug()) {
            Log.e(tag, message);
        }
    }

    public static void v(@NonNull String tag, String message) {
        if (isDebug()) {
            Log.v(tag, message);
        }
    }
}
