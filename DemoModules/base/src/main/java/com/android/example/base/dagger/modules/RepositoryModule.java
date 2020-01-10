package com.android.example.base.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;


import com.android.example.base.dagger.BaseApplicationScope;
import com.android.example.base.repository.sharedpref.LocalRepository;
import com.android.example.base.repository.sharedpref.MainRepository;
import com.android.example.base.repository.sharedpref.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @BaseApplicationScope
    @Provides
    LocalRepository localRepository(SharedPreferences sharedPreferences) {
        return new PreferenceManager(sharedPreferences);
    }

    @BaseApplicationScope
    @Provides
    SharedPreferences sharedPreferences(Context context) {
        return context.getSharedPreferences(PreferenceManager.PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @BaseApplicationScope
    MainRepository mainRepository(LocalRepository localRepository) {
        return new MainRepository(localRepository);
    }
}
