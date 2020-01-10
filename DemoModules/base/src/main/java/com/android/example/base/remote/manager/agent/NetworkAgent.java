
package com.android.example.base.remote.manager.agent;

import androidx.annotation.NonNull;

import com.android.example.base.data.networkModel.response.base.BaseResponse;
import com.android.example.base.remote.Error;
import com.android.example.base.remote.RequestExecutor;
import com.android.example.base.remote.RequestModel;
import com.android.example.base.remote.ResponseCallback;
import com.android.example.base.remote.ResponseNotifier;
import com.android.example.base.remote.RxSchedulers;

public class NetworkAgent extends RequestExecutor {

    @Override
    public void execute(final RequestModel requestData, @NonNull final ResponseNotifier callback) {
        mDisposableObserver = super.getResponseObserver(new ResponseCallback() {


            @Override
            public void onComplete(BaseResponse response) {

                    if (callback != null) {

                        if (response == null) {
                            callback.onSuccess(new BaseResponse());
                        } else {
                            callback.onSuccess(response);
                        }
                }
            }

            @Override
            public void onFailure(Error error) {
                if (callback != null)
                    callback.onFailure(error);
            }

        }, requestData.getApiConstants());
        requestData.getObservable()
                .subscribeOn(RxSchedulers.getIOThread())
                .observeOn(RxSchedulers.getMainThread())
                .subscribeWith(mDisposableObserver);
    }

    /**
     * returns true if status code is valid
     *
     * @param code
     * @return
     */
    //private boolean isValidStatus(int code) {
    //  return code >= 200 && code < 300;
    //}

    /**
     * saves response in Cache
     *
     * @param fileName
     * @param response
     */
    /*private void cacheInFile(String fileName, BaseResponse response) {
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // FileUtils.writeStringAsFile(gson.toJson(response), fileName);
    }*/
}
