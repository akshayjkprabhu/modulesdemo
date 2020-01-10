package com.android.example.base.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.example.base.BaseApplication;
import com.android.example.base.event.NetworkEvent;
import com.android.example.base.event.rxbus.RxBus;
import com.android.example.base.utils.NetworkUtils;

import javax.inject.Inject;

public class NetworkBroadCastReceiver extends BroadcastReceiver {

    @Inject
    RxBus mRxBus;

    @Override
    public void onReceive(Context context, Intent intent) {

        BaseApplication.getInstance().getApplicationComponent().inject(this);

        NetworkEvent event = new NetworkEvent();
        if (NetworkUtils.isNetworkAvailable())
            event.setConnected(true);
        else
            event.setConnected(false);
        mRxBus.send(event);
    }

}