
package com.android.example.base.event.rxbus;

import com.android.example.base.event.BaseRxEvent;

import io.reactivex.Observable;

public interface RxBus {

    void send(final BaseRxEvent event);

    Observable<Object> toObservable();

    boolean hasObservers();
}