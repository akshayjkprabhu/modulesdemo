package com.android.example.base.dagger;

import android.app.Application;

import com.android.example.base.dagger.modules.ApplicationModule;
import com.android.example.base.dagger.modules.ConfigModule;
import com.android.example.base.dagger.modules.NetworkModule;
import com.android.example.base.dagger.modules.RepositoryModule;
import com.android.example.base.dagger.modules.RxModule;
import com.android.example.base.data.networkModel.response.base.BaseSubErrorResponse;
import com.android.example.base.remote.ApiRequestUtils;
import com.android.example.base.remote.NetworkBroadCastReceiver;
import com.android.example.base.remote.RequestExecutor;
import com.android.example.base.remote.manager.BaseManager;
import com.android.example.base.ui.BaseActivity;
import com.android.example.base.ui.BaseFragment;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        ConfigModule.class,
        RxModule.class})
@BaseApplicationScope
public interface BaseAppComponent {

    void inject(BaseActivity baseActivity);

    void inject(ApiRequestUtils apiRequestUtils);

    void inject(BaseSubErrorResponse baseSubErrorResponse);

    void inject(NetworkBroadCastReceiver networkBroadCastReceiver);

    void inject(RequestExecutor requestExecutor);

    void inject(BaseManager baseManager);

    void inject(BaseFragment baseFragment);


    @Component.Builder
    interface Builder {
        BaseAppComponent build();

        @BindsInstance
        Builder application(Application application);

    }
}
