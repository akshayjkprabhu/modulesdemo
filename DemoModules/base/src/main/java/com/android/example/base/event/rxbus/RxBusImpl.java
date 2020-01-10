
package com.android.example.base.event.rxbus;


import com.android.example.base.event.BaseRxEvent;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBusImpl implements RxBus {

    private final PublishSubject<Object> mBus;

    public RxBusImpl() {
        mBus = PublishSubject.create();
    }

    @Override
    public void send(BaseRxEvent event) {
        mBus.onNext(event);
    }

    @Override
    public Observable<Object> toObservable() {
        return mBus;
    }

    @Override
    public boolean hasObservers() {
        return mBus.hasObservers();
    }

}
