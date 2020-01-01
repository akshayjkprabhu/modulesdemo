package com.android.example.base.ui.model;

import androidx.annotation.NonNull;

public class UISettings {

    @NonNull
   public static UISettings getDefaultSettings() {
        return new UISettings();
    }

    private boolean drawerEnabled;
    private boolean toolbarEnabled;
    private boolean bottomBarEnabled;

    public boolean isDrawerEnabled() {
        return true;
    }

    public boolean isBottomBarEnabled() {
        return true;
    }

    public boolean isToolbarEnabled() {
        return true;
    }
}
