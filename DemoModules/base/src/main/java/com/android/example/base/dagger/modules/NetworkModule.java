package com.android.example.base.dagger.modules;

import android.content.Context;

import com.android.example.base.BuildConfig;
import com.android.example.base.dagger.BaseApplicationScope;
import com.android.example.base.remote.ApiService;
import com.android.example.base.utils.NetworkUtils;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@BaseApplicationScope
public class NetworkModule {
    private static final String HEADER_APP_VERSION = "app-version";
    private static final String HEADER_SESSION_TOKEN = "session-token";
    private static final String HEADER_APP_VERSION_CODE = "version-code";
    private static final String HEADER_APP_DEVICE_ID = "device-id";
    private static final String HEADER_OS = "os";
    private static final String HEADER_CHANNEL = "channel";
    private static final String DOMAIN_PATTERN = "nexa.bharatbank.com";

    @Provides
    @BaseApplicationScope
    ApiService getApiService(OkHttpClient okHttpClient) {
//        String baseUrl = BuildConfig.SERVER_ADDRESS + BuildConfig.API_VERSION;
        String baseUrl = "";
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Provides
    @BaseApplicationScope
    CommonRequestInterceptor getAuthenticatedHeader() {
        return new CommonRequestInterceptor();
    }

    @Provides
    @BaseApplicationScope
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor interceptor,
                                 CommonRequestInterceptor authenticationInterceptor) {
        OkHttpClient okHttpClient = null;
        try {
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(authenticationInterceptor)
                    .addInterceptor(interceptor);
            okHttpClient = okHttpClientBuilder.build();

        } catch (Exception e) {

        }
        return okHttpClient;
    }

    @Provides
    @BaseApplicationScope
    HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level loggingLevel = (BuildConfig.DEBUG)
                ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;
        interceptor.setLevel(loggingLevel);
        return interceptor;

    }

    @Provides
    @BaseApplicationScope
    NetworkUtils getNetworkUtils(Context context) {
        return new NetworkUtils(context);
    }

    class CommonRequestInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder requestBuilder = chain.request().newBuilder();
//                    .addHeader(HEADER_OS, Constants.MOBILE_OS)
//                    .addHeader(HEADER_APP_VERSION, BuildConfig.VERSION_NAME)
//                    .addHeader(HEADER_APP_DEVICE_ID, CommonUtils.getAndroidId(SuvarnaApplication.getInstance()))
//                    .addHeader(HEADER_APP_VERSION_CODE, String.valueOf(BuildConfig.VERSION_CODE))
//                    .addHeader(HEADER_CHANNEL, "11");
/*            String sessionToken = SuvarnaApplication.getInstance().getApplicationComponent()
                    .getMainRepository().getSessionToken();

            if (!ValidationUtils.isEmpty(sessionToken)) {
                requestBuilder.addHeader(HEADER_SESSION_TOKEN, sessionToken);
            }*/
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }
}
