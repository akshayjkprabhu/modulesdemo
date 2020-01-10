package com.android.example.base.ui.model;

public class BottomBarSettings {
    private boolean enabled;
    public static BottomBarSettings getDefaultSettings() {
        return new BottomBarSettings();
    }

    public boolean isEnabled() {
        return enabled;
    }
}
