package com.android.example.base.remote;

import android.text.TextUtils;

import com.android.example.base.data.networkModel.response.base.BaseSubErrorResponse;


public class Error {

    private int mCode;
    private String mApiMessage;
    private String mReferenceNumber;
    private BaseSubErrorResponse mErrorObject;
    @NetworkConstants.Api
    private int mApi;
    private String mUiMessage;
    private String mTitle;

    public Error(int code) {
        mCode = code;
    }
    public Error(int code, int api) {
        mCode = code;
        mApi = api;
    }


    public Error(int code, String apiMessage) {
        this.mCode = code;
        this.mApiMessage = apiMessage;
    }

    public Error() {

    }

    public Error(int status, String message, BaseSubErrorResponse errorObject) {
        mCode = status;
        mApiMessage = message;
        mErrorObject = errorObject;
    }

    public Error(int status, String message, BaseSubErrorResponse errorObject, String referenceNo) {
        mCode = status;
        mApiMessage = message;
        mErrorObject = errorObject;
        mReferenceNumber = referenceNo;
    }

    public String getReferenceNumber() {
        return mReferenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        mReferenceNumber = referenceNumber;
    }

    public BaseSubErrorResponse getErrorObject() {
        return mErrorObject;
    }

    public void setErrorObject(BaseSubErrorResponse errorObject) {
        mErrorObject = errorObject;
    }

    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getmApiMessage() {
        return mApiMessage;
    }

    public void setmApiMessage(String mApiMessage) {
        this.mApiMessage = mApiMessage;
    }

    public int getmApi() {
        return mApi;
    }

    public void setmApi(int mApi) {
        this.mApi = mApi;
    }

    public String getmUiMessage() {
        return mUiMessage;
    }

    public void setmUiMessage(String mUiMessage) {
        this.mUiMessage = mUiMessage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public String getApiMessage() {
        return mApiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.mApiMessage = TextUtils.isEmpty(apiMessage) ? NetworkConstants.UNKNOWN_ERROR_MESSAGE : apiMessage;
    }
    @NetworkConstants.Api
    public int getApi() {
        return mApi;
    }

    public void setApi(@NetworkConstants.Api int api) {
        this.mApi = api;
    }

    public boolean show() {
        return this.mCode == APIStatus.NO_INTERNET
                || this.mCode == APIStatus.TIME_OUT
                || this.mCode == APIStatus.SERVICE_UNAVAILABLE;
    }

}
