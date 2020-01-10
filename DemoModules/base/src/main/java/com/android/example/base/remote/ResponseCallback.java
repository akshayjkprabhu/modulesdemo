package com.android.example.base.remote;

import com.android.example.base.data.networkModel.response.base.BaseResponse;

/**
 * Created by vijayalaxmi on 30/8/17.
 */

public interface ResponseCallback {
    void onComplete(BaseResponse response);
    void onFailure(Error error);
}
