package com.android.example.base.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.example.base.ui.model.BottomBarSettings;
import com.android.example.base.ui.model.ToolbarSettings;
import com.android.example.base.ui.model.UISettings;

public class BaseViewModel extends AndroidViewModel {

    private MutableLiveData<UISettings> mUiLiveData = new MutableLiveData<>();
    private MutableLiveData<BottomBarSettings> mBottomBarLiveData = new MutableLiveData<>();
    private MutableLiveData<ToolbarSettings> mToolbarLiveData = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @NonNull
    public MutableLiveData<UISettings> getUiLiveData() {
        return mUiLiveData;
    }

    public MutableLiveData<BottomBarSettings> getmBottomBarLiveData() {
        return mBottomBarLiveData;
    }

    public MutableLiveData<ToolbarSettings> getmToolbarLiveData() {
        return mToolbarLiveData;
    }

    public void setDefaultUISettings() {
        mUiLiveData.postValue(UISettings.getDefaultSettings());
    }

    public void setDefaultBottomBarSettings() {
        mBottomBarLiveData.postValue(BottomBarSettings.getDefaultSettings());
    }

    public void setDefaultToolbarSettings() {
        mToolbarLiveData.postValue(ToolbarSettings.defaultSettings());
    }
}
