package com.android.example.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.android.example.base.DemoApplication;
import com.android.example.base.ui.BaseActivity;
import com.android.example.base.viewmodel.BaseViewModel;
import com.android.example.base.ui.model.UISettings;

public class AppLauncher extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void readFromBundle() {

    }

    @NonNull
    @Override
    protected BaseViewModel getViewModel() {
        return ViewModelProvider.AndroidViewModelFactory
                .getInstance(DemoApplication.getInstance())
                .create(BaseViewModel.class);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_splash;
    }

    @NonNull
    @Override
    protected UISettings getUISettings() {
        return new UISettings();
    }
}
