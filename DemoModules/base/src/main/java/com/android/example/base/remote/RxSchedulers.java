package com.android.example.base.remote;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulers {
    private RxSchedulers() {
        //Avoid initialisation
    }

    public static Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }

    public static Scheduler getIOThread() {
        return Schedulers.io();
    }
}
