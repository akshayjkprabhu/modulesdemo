package com.android.example.base.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.example.base.ui.model.UISettings;

public class BaseViewModel extends AndroidViewModel {

    private MutableLiveData<UISettings> mUiLiveData = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @NonNull
    public MutableLiveData<UISettings> getUiLiveData() {
        return mUiLiveData;
    }

    public void setDefaultSettings() {
        getUiLiveData().postValue(UISettings.getDefaultSettings());
    }
}
