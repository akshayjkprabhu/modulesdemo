package com.android.example.base.remote;

import androidx.annotation.NonNull;


public interface RequestAgent {
    /**
     * executes API request
     * @param requestData - query parameters
     * @param callback    - response callback
     */
    void execute(RequestModel requestData, @NonNull ResponseNotifier callback);

    void unSubscribe();
}
