package com.android.example.base.remote;

public class APIStatus {

    public static final int SSL_ERROR = 701;
    public static final int CODE_200 = 200;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORISED = 401;
    public static final int UN_PROCESSABLE_ENTITY = 422;
    public static final int ACCOUNT_LOCKED = 423;
    public static final int NO_CONTENT = 204;
    public static final int REDIRECT = 307;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int INVALID_API_KEY = 498;
    public static final int TOKEN_UNAVAILABLE = 499;
    public static final int UNKNOWN = 0;
    public static final int NO_INTERNET = 2000;
    public static final int TIME_OUT = 2001;
    public static final int JSON_PARSING_ERROR = 2002;
    public static final int DATA_NOT_FOUND = 2003;
    public static final int DB_ERROR = 2004;
    public static final int CERTIFICATE_ERROR = 2005;
    public static final int REQUEST_RETRY = 2006;
    public static final int CONNECTION_EXCEPTION = 2007;
    public static final int EMPTY_EXCEPTION = 2008;

    private APIStatus() {
        //Avoid initialisation
    }


}
