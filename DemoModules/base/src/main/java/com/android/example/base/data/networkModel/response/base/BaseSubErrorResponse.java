package com.android.example.base.data.networkModel.response.base;

import android.content.Context;
import android.text.TextUtils;

import com.android.example.base.BaseApplication;
import com.google.gson.annotations.SerializedName;

import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by nidhin on 27/11/17.
 */

public class BaseSubErrorResponse {
    @SerializedName("errorCode")
    String errorCode;
    @SerializedName("errorMessage")
    String errorMessage;
    @Inject
    Context mContext;

    BaseSubErrorResponse() {
        BaseApplication.getInstance().getApplicationComponent().inject(this);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        if (Locale.getDefault().getLanguage().equalsIgnoreCase("hi")) {
            if (!TextUtils.isEmpty(errorCode)) {
                String newMessage;
                if (errorCode.startsWith("-")) {
                    String newErrorCode = "m" + errorCode.substring(1);
                    newMessage = getStringResourceByName(newErrorCode);
                } else {
                    String newErrorCode = "p" + errorCode;
                    newMessage = getStringResourceByName(newErrorCode);
                }
                if (!TextUtils.isEmpty(newMessage)) {
                    return newMessage;
                }
            }
        }
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {


        this.errorMessage = errorMessage;
    }

    private String getStringResourceByName(String aString) {
        String packageName = mContext.getPackageName();
        int resId = mContext.getResources().getIdentifier(aString, "string", packageName);
        return mContext.getString(resId);
    }
}
