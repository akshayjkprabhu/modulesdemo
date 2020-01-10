package com.android.example.base.remote;

import androidx.annotation.Nullable;

import com.android.example.base.BaseApplication;
import com.android.example.base.data.networkModel.response.base.BaseResponse;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Abstract class extended by all the API manger classes
 */
public abstract class RequestExecutor implements RequestAgent {

    @Inject
    protected ApiService mAPIService;
    @Nullable
    protected DisposableObserver mDisposableObserver;
    private int mApiId;

    public RequestExecutor() {
        BaseApplication.getInstance().getApplicationComponent().inject(this);
    }

    /**
     * Override this method to manipulate the received response
     */
    public <T> Object getData(T data) {
        return data;
    }

    /**
     * un-subscribes observers
     */
    public final void unSubscribe() {
        if (mDisposableObserver != null && !mDisposableObserver.isDisposed()) {
            mDisposableObserver.dispose();
            mDisposableObserver = null;
        }
    }

    protected <T> DisposableObserver<T> getResponseObserver(final ResponseCallback callback, @NetworkConstants.Api final int networkConstant) {
        mApiId = networkConstant;
        return new DisposableObserver<T>() {
            @Override
            public void onNext(T response) {
                if (callback != null && response != null) {
                    BaseResponse res = (BaseResponse) response;
                    if (isCodeValid(res.getStatus())) {
                        callback.onComplete(res);
                    } else {
                        try {
                            callback.onFailure(createError(res));
                        } catch (Exception e) {
                            e.printStackTrace();
                            callback.onFailure(new Error(NetworkConstants.CODE_INTERNAL_SERVER_ERROR));
                        }
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                unSubscribe();
                handleFailureCase(t, networkConstant, callback);
            }

            @Override
            public void onComplete() {
                unSubscribe();
            }
        };
    }


    private void handleFailureCase(Throwable t, @NetworkConstants.Api int networkConstant, ResponseCallback callback) {
        Error error = new ResponseParser().parseError(t, networkConstant);
        if (callback != null) {
            callback.onFailure(error);
        }
    }

    private Error createError(BaseResponse baseResponse) {
      /*  if (baseResponse.getData() != null && baseResponse.getData() instanceof FundTransferAuthResponse) {
            BaseSubResponse baseSubResponse = (BaseSubResponse) baseResponse.getData();
            if (baseResponse != null && baseSubResponse.getReferenceNo() != null) {
                return new Error(baseResponse.getStatus(), baseResponse.getMessage(), baseResponse.getErrorObject(), baseSubResponse.getReferenceNo());
            }
        }*/
        return new Error(baseResponse.getStatus(), baseResponse.getMessage(), baseResponse.getErrorObject());
    }

    private boolean isCodeValid(int code) {
        return code >= 0;
    }
}
