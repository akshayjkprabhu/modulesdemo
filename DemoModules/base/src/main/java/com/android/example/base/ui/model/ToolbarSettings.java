package com.android.example.base.ui.model;

public class ToolbarSettings {

    private boolean enabled;

    public static ToolbarSettings defaultSettings() {
        return new ToolbarSettings();
    }

    public boolean isEnabled() {
        return enabled;
    }
}
