package com.android.example.base.remote.manager;

import android.content.Context;

import com.android.example.base.BaseApplication;
import com.android.example.base.event.rxbus.RxBus;
import com.android.example.base.remote.Error;
import com.android.example.base.remote.RequestAgent;
import com.android.example.base.remote.RequestModel;
import com.android.example.base.remote.ResponseNotifier;
import com.android.example.base.remote.manager.agent.NetworkAgent;
import com.android.example.base.utils.NetworkUtils;

import javax.inject.Inject;

public class BaseManager {
    RequestAgent mRequestAgent;
    @Inject
    Context mContext;
    @Inject
    RxBus mRxBus;

    public BaseManager() {
        BaseApplication.getInstance().getApplicationComponent().inject(this);
    }

    public void execute(RequestModel requestData, ResponseNotifier callback) {

        if (NetworkUtils.isNetworkAvailable()) {
            mRequestAgent = new NetworkAgent();
            mRequestAgent.execute(requestData, callback);
        } else {
            Error error = new Error();
            error.setCode(1001);
            callback.onFailure(error);
        }
    }

    public void unsubscribe() {
        if (mRequestAgent != null)
            mRequestAgent.unSubscribe();
    }
}
