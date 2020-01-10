package com.android.example.base;

import android.app.Application;

import com.android.example.base.dagger.BaseAppComponent;
import com.android.example.base.dagger.DaggerBaseAppComponent;

public abstract class BaseApplication extends Application {

    private static BaseApplication sInstance;
    private BaseAppComponent mAppComponent;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initDagger();
    }

    protected void initDagger() {
        mAppComponent = DaggerBaseAppComponent
                .builder()
                .application(this)
                // .applicationModule(new ApplicationModule(this))
                .build();
    }


    public BaseAppComponent getApplicationComponent() {
        return mAppComponent;
    }
}

