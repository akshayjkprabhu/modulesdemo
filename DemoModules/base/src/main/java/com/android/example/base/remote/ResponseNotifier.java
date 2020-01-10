package com.android.example.base.remote;


public interface ResponseNotifier<T> {

    void onSuccess(T response);
    void onFailure(Error error);
}