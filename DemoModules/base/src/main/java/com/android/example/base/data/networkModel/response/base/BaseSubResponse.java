package com.android.example.base.data.networkModel.response.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nidhin on 17/11/17.
 */

public class BaseSubResponse {
    @Expose
    @SerializedName("referenceNo")
    String referenceNo;
    @Expose
    @SerializedName("requestTime")
    String requestTime;
    @SerializedName("registerTransaction")
    @Expose
    String registerTransaction;
    @Expose
    @SerializedName("bankRefNo")
    String bankRefNumber;


    public String getBankRefNumber() {
        return bankRefNumber;
    }

    public void setBankRefNumber(String bankRefNumber) {
        this.bankRefNumber = bankRefNumber;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }
    public String getRegisterTransaction() {
        return registerTransaction;
    }



}
