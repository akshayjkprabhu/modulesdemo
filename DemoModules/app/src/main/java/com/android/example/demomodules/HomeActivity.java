package com.android.example.demomodules;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.example.base.ui.BaseActivity;
import com.android.example.base.viewmodel.BaseViewModel;

public class HomeActivity extends BaseActivity {

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
        return null;
    }

    @Override
    protected int getContentResId() {
        return 0;
    }
}
