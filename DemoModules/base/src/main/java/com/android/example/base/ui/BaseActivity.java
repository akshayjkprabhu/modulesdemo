package com.android.example.base.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;

import com.android.example.base.R;
import com.android.example.base.ui.model.UISettings;
import com.android.example.base.utils.Logger;
import com.android.example.base.viewmodel.BaseViewModel;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    // Drawer field can be null if drawer is not enabled for the screen
    private DrawerLayout mDrawer;

    private FrameLayout mContent;
    private FrameLayout mBottomNavigation;
    private FrameLayout mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        observeLiveData();
        readFromBundle();
        setContentView();
        initViews();
        loadDefaults();
    }

    private void loadDefaults() {
        getViewModel().setDefaultSettings();
    }

    protected abstract void readFromBundle();

    @NonNull
    protected abstract BaseViewModel getViewModel();

    protected void observeLiveData() {
        BaseViewModel viewModel = getViewModel();
        viewModel.getUiLiveData().observe(this, new Observer<UISettings>() {
            @Override
            public void onChanged(UISettings uiSettings) {
                onUISettingsChanged(uiSettings);
            }
        });
    }

    protected void onUISettingsChanged(@Nullable UISettings uiSettings) {
        Logger.d(TAG, "onUISettingsChanged");
        if (uiSettings != null) {
        }
    }

    private void initViews() {
        mDrawer = findViewById(R.id.drawer);
        mContent = findViewById(R.id.lyt_content);
        mBottomNavigation = findViewById(R.id.lyt_bottom_bar);
        addMainContent();
    }

    private void addMainContent() {
        int contentResId = getContentResId();
        if (contentResId != 0) {
            mContent.removeAllViews();
            getLayoutInflater().inflate(contentResId, mContent);
        }
    }

    @LayoutRes
    protected abstract int getContentResId();


    public void setContentView() {

    }
}
