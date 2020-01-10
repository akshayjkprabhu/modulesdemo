package com.android.example.base.dagger.modules;


import com.android.example.base.dagger.BaseApplicationScope;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfigModule {

    @Provides
    @BaseApplicationScope
    public Gson providesGson() {
        return new Gson();
    }
}