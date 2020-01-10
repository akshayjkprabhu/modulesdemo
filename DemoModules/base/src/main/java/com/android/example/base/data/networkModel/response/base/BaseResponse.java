package com.android.example.base.data.networkModel.response.base;

import com.android.example.base.remote.NetworkConstants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 8/11/17.
 */

public class BaseResponse<T> {

    @SerializedName("status")
    private int mStatus;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("data")
    private T mData;
    @SerializedName("error")
    private BaseSubErrorResponse mErrorObject;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        this.mStatus = status;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public boolean isSuccess() {
        return getStatus() >= NetworkConstants.StatusCodes.SUCCESS;
    }

    public BaseSubErrorResponse getErrorObject() {
        return mErrorObject;
    }

    public void setErrorObject(BaseSubErrorResponse errorObject) {
        mErrorObject = errorObject;
    }
}
