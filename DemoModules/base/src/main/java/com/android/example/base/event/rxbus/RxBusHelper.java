
package com.android.example.base.event.rxbus;
import com.android.example.base.utils.Logger;

import io.reactivex.observers.DisposableObserver;

public class RxBusHelper {

    private DisposableObserver<Object> mDisposable;

    public void registerEvents(RxBus rxBus, final String tag, final RxBusCallback callback) {

        if (rxBus != null) {
            mDisposable = new DisposableObserver<Object>() {
                @Override
                public void onNext(Object event) {
                    callback.onEventTrigger(event);
                }

                @Override
                public void onError(Throwable e) {
                    Logger.d(tag, "Event : onError : " + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Logger.d(tag, "Event : onComplete");
                }
            };
            rxBus.toObservable().share().subscribeWith(mDisposable);
        }
    }

    public void unSubScribe() {

        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
            mDisposable = null;
        }
    }
}
