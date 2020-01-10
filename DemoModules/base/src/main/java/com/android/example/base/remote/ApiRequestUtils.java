package com.android.example.base.remote;

import com.android.example.base.BaseApplication;

import javax.inject.Inject;


public class ApiRequestUtils {

    private static ApiRequestUtils mInstance;
    @Inject
    protected ApiService mAPIService;

    private ApiRequestUtils() {
        BaseApplication.getInstance().getApplicationComponent().inject(this);
    }

    public static ApiRequestUtils getInstance() {
        if (mInstance == null)
            mInstance = new ApiRequestUtils();
        return mInstance;
    }

/*
    public RequestModel setPrimaryAccount(AccountDetailRequest account) {
        Observable<BaseResponse> observable = mAPIService.setPrimaryAccount
                (account);
        return new RequestModel.RequestBuilder(NetworkConstants.API_SET_PRIMARY_ACCOUNT, BaseResponse
                .class, observable).build();
    }*/

}