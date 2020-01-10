package com.android.example.base.remote;



/**
 * Created by vijayalaxmi on 7/9/17.
 */

public class ErrorHandler {
    Error mError;


    public ErrorHandler(Error code) {
        mError = code;
    }


    public Error createErrorObject() {
        Error error = new Error();
        error.setmTitle("Error");
        error.setmUiMessage("Api Error");
        /*switch (mError.getCode()) {
            case NetworkConstants.CODE_INVALID_INPUT:
                error.setmUiMessage("Api Error");
                break;
        }*/

        return error;
    }
}
