package com.android.example.base.repository.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.android.example.base.BaseApplication;

import javax.inject.Inject;

public class PreferenceManager implements LocalRepository {

    public static final String PREF_NAME = "demo_pref";
    private static SharedPreferences mSharedPreference;

    /**
     * @param sharedPreferences
     */
    @Inject
    public PreferenceManager(@NonNull SharedPreferences sharedPreferences) {
        mSharedPreference = sharedPreferences;
    }

    public PreferenceManager() {
    }

    public static void writeBoolean(String key, boolean value) {
        getEditor().putBoolean(key, value).commit();
    }

    public static boolean readBoolean(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    public static void writeInteger(String key, int value) {
        getEditor().putInt(key, value).commit();
    }

    public static int readInteger(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    public static void writeString(String key, String value) {
        getEditor().putString(key, value).commit();
    }

    public static String readString(String key, String defValue) {
        return getPreferences().getString(key, defValue);
    }

    private static SharedPreferences getPreferences() {
        return BaseApplication.getInstance()
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    private SharedPreferences.Editor edit() {
        return mSharedPreference.edit();
    }

    /**
     * Repository Methods
     */
    @Override
    public void save(String key, String value) {
        edit().putString(key, value).commit();
    }

    @Override
    public String getString(String key) {
        return mSharedPreference.getString(key, "");
    }

    @Override
    public void clearAll() {
        mSharedPreference.edit().clear().commit();
    }
}