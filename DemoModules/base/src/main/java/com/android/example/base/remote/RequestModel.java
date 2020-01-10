package com.android.example.base.remote;


import com.android.example.base.data.networkModel.response.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.Response;

public class RequestModel<T> {

    private @NetworkConstants.Api int apiConstants;
    private Class<BaseResponse> mModel;
    private Observable<Response<T>> observable;

    private RequestModel(RequestBuilder builder) {
        apiConstants = builder.apiConstants;
        mModel = builder.mModel;
        this.observable = builder.observable;
    }

    public Observable<Response<T>> getObservable() {
        return observable;
    }

    public void setObservable(Observable<Response<T>> observable) {
        this.observable = observable;
    }

    public @NetworkConstants.Api int getApiConstants() {
        return apiConstants;
    }

    public Class<BaseResponse> getmModel() {
        return mModel;
    }


    public static class RequestBuilder<T> {
        private int apiConstants;
        private Class<BaseResponse> mModel;
        private Observable<Response<T>> observable;

        public RequestBuilder(int requestType, Class requestClass , Observable<Response<T>> observable) {
            // Set Default Value Her
            apiConstants = requestType;
            mModel = requestClass;
            this.observable = observable;
        }

        public RequestModel build() {
            return new RequestModel(this);
        }
    }

}
