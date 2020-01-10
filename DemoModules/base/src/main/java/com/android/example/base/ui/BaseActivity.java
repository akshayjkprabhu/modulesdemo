package com.android.example.base.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;

import com.android.example.base.BaseApplication;
import com.android.example.base.R;
import com.android.example.base.event.rxbus.RxBus;
import com.android.example.base.event.rxbus.RxBusCallback;
import com.android.example.base.event.rxbus.RxBusHelper;
import com.android.example.base.ui.model.BottomBarSettings;
import com.android.example.base.ui.model.ToolbarSettings;
import com.android.example.base.ui.model.UISettings;
import com.android.example.base.utils.Logger;
import com.android.example.base.viewmodel.BaseViewModel;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity
        implements RxBusCallback {

    private static final String TAG = BaseActivity.class.getSimpleName();

    // Drawer field can be null if drawer is not enabled for the screen
    private DrawerLayout mDrawer;
    private FrameLayout mContent;
    private FrameLayout mBottomNavigation;
    private FrameLayout mToolbar;

    //Injection
    @Inject
    RxBus mRxBus;
    private RxBusHelper mRxBusHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
        registerEvents();
        readFromBundle();
        observeLiveData();
        setContentView();
        initViews();
        loadDefaults();
    }

    private void initDagger() {
        BaseApplication.getInstance().getApplicationComponent().inject(this);
    }

    /**
     * Registers for the RxBus events
     */
    private void registerEvents() {
        mRxBusHelper = new RxBusHelper();
        mRxBusHelper.registerEvents(mRxBus, TAG, this);
    }

    protected void loadDefaults() {
        getViewModel().setDefaultToolbarSettings();
        getViewModel().setDefaultUISettings();
        getViewModel().setDefaultBottomBarSettings();
    }

    protected abstract void readFromBundle();

    @NonNull
    protected abstract BaseViewModel getViewModel();

    protected void observeLiveData() {
        BaseViewModel viewModel = getViewModel();
        viewModel.getUiLiveData().observe(this, new Observer<UISettings>() {
            @Override
            public void onChanged(UISettings uiSettings) {
                onUISettingsChanged(uiSettings);
            }
        });
        viewModel.getmBottomBarLiveData().observe(this, new Observer<BottomBarSettings>() {
            @Override
            public void onChanged(BottomBarSettings settings) {
                updateBottomBar(settings);
            }
        });

        viewModel.getmToolbarLiveData().observe(this, new Observer<ToolbarSettings>() {
            @Override
            public void onChanged(ToolbarSettings uiSettings) {
                updateToolbar(uiSettings);
            }
        });

    }

    private void updateBottomBar(BottomBarSettings settings) {
        Logger.d(TAG, "updateBottombar");
        if (settings != null) {
            mBottomNavigation.setVisibility(settings.isEnabled() ? View.VISIBLE : View.GONE);
        }
    }

    private void updateToolbar(ToolbarSettings settings) {
        Logger.d(TAG, "updateToolbar");
        if (settings != null) {
            mToolbar.setVisibility(settings.isEnabled() ? View.VISIBLE : View.GONE);
        }
    }

    protected void onUISettingsChanged(@Nullable UISettings uiSettings) {
        Logger.d(TAG, "onUISettingsChanged");
        if (uiSettings != null) {
        }
    }

    private void initViews() {
        mDrawer = findViewById(R.id.drawer);
        mContent = findViewById(R.id.lyt_content);
        mBottomNavigation = findViewById(R.id.lyt_bottom_bar);
        addMainContent();
    }

    private void addMainContent() {
        int contentResId = getContentResId();
        if (contentResId != 0) {
            mContent.removeAllViews();
            getLayoutInflater().inflate(contentResId, mContent);
        }
    }

    @LayoutRes
    protected abstract int getContentResId();

    /**
     * Use this RxBus to send events
     */
    protected RxBus getRxBus() {
        return mRxBus;
    }

    public void setContentView() {
        UISettings settings = getViewModel().getUiLiveData().getValue();
        setContentView(settings != null && settings.isDrawerEnabled() ?
                R.layout.drawer_layout : R.layout.content_layout);
    }

    @Override
    public void onEventTrigger(Object event) {
        Logger.d(TAG, "onEventTrigger : " + event);
        //todo handle the network disabled error here

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribeEvents();
    }

    private void unSubscribeEvents() {
        if (mRxBusHelper != null) {
            mRxBusHelper.unSubScribe();
        }
    }
}
