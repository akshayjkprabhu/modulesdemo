package com.android.example.base.dagger.modules;

import com.android.example.base.dagger.BaseApplicationScope;
import com.android.example.base.event.rxbus.RxBus;
import com.android.example.base.event.rxbus.RxBusImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @BaseApplicationScope
    @Provides
    RxBus provideRxBus() {
        return new RxBusImpl();
    }
}
