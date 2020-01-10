package com.android.example.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.example.base.BaseApplication;
import com.android.example.base.event.BaseRxEvent;
import com.android.example.base.event.rxbus.RxBus;
import com.android.example.base.event.rxbus.RxBusCallback;
import com.android.example.base.event.rxbus.RxBusHelper;
import com.android.example.base.utils.Logger;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment implements RxBusCallback {

    private static final String TAG = BaseFragment.class.getSimpleName();

    @Inject
    RxBus mRxBus;
    private RxBusHelper mRxBusHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initDagger();
        readFromArguments(getArguments());
        registerEvents();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void registerEvents() {
        Logger.d(TAG, "RegisterEvents");
        mRxBusHelper = new RxBusHelper();
        mRxBusHelper.registerEvents(mRxBus, TAG, this);
    }

    protected abstract void readFromArguments(@Nullable Bundle arguments);

    private void initDagger() {
        BaseApplication.getInstance()
                .getApplicationComponent()
                .inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    /**
     * Override this to handle view initializations
     *
     * @param view
     */
    protected void initViews(@NonNull View view) {
        Logger.d(TAG, "initView : " + view);

    }

    @Override
    public void onEventTrigger(Object event) {
        if (event instanceof BaseRxEvent) {
            handleEvents(((BaseRxEvent) event));
        }
    }

    /**
     * Override this to handle all the RxBus Events
     *
     * @param event is an RxBus Event
     */
    protected void handleEvents(BaseRxEvent event) {
        Logger.d(TAG, "handleEvents : " + event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unRegisterEvents();
    }

    private void unRegisterEvents() {
        if (mRxBusHelper != null) {
            mRxBusHelper.unSubScribe();
            mRxBusHelper = null;
        }
    }
}
