package com.android.example.base.remote;

import androidx.annotation.IntDef;

/**
 * Created by root on 8/11/17.
 */

public class NetworkConstants {
    public static final int CODE_SUCCESS = 200;
    public static final int API_REGISTER = 100;
    static final int CODE_INTERNAL_SERVER_ERROR = 500;
    //Network Error Messages
    public static String UNKNOWN_ERROR_MESSAGE = "Something went wrong, please try later";

    @IntDef({})
    public @interface Api {
        int REGISTER = 100;
    }

    public @interface StatusCodes {
        int SUCCESS = 200;
        int INTERNAL_SERVER_ERROR = 500;
    }
}
