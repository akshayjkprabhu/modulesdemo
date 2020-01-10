package com.android.example.base.remote;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

import retrofit2.HttpException;
import retrofit2.Response;

public class ResponseParser {
    public Error parseError(Throwable t, @NetworkConstants.Api int api) {
        Error error = new Error();
        error.setApi(api);
        if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            error.setCode(httpException.code());
        } else if (t instanceof SSLPeerUnverifiedException || t instanceof SSLHandshakeException) {
            error.setCode(APIStatus.SSL_ERROR);
        } else if (t instanceof ConnectException) {
            error.setCode(APIStatus.CONNECTION_EXCEPTION);
        } else if (t instanceof SocketTimeoutException) {
            error.setCode(APIStatus.TIME_OUT);
        } else if (t instanceof IOException) {
            error.setCode(APIStatus.NO_INTERNET);
        } else if (t instanceof JsonSyntaxException) {
            error.setCode(APIStatus.JSON_PARSING_ERROR);
        }
        return error;
    }

    public Error paresError(Response response, @NetworkConstants.Api int api) {
        Error error = new Error();
        error.setApi(api);
        if (response != null && response.code() > 0) {
            error.setCode(response.code());
            error.setApiMessage(response.message());
        } else {
            //  error.setCode(APIStatus.UNKNOWN_ERROR);
            error.setApiMessage("unknown");
        }
        return error;
    }


}



