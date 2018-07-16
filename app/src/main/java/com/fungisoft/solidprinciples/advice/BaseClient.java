package com.fungisoft.solidprinciples.advice;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {

    protected BadSecuredApiService getService() {
        return getRetrofit().create(BadSecuredApiService.class);
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("example.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    protected GoodSecuredApiService getSecuredService() {
        return getRetrofit().create(GoodSecuredApiService.class);
    }

    private Retrofit securedRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("example.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getAuthClient())
                .build();
    }

    private OkHttpClient getAuthClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String email = getEmail();
                        String token = getToken();
                        if (email.isEmpty() || token.isEmpty()) {
                            return chain.proceed(chain.request());
                        }

                        Request authorisedRequest = chain.request().newBuilder()
                                .addHeader("user", email)
                                .addHeader("token", token)
                                .build();

                        return chain.proceed(authorisedRequest);
                    }
                }).build();
    }

    private String getEmail() {
        return PreferencesUtil.getUser(AppController.getInstance());
    }

    private String getToken() {
        return PreferencesUtil.getToken(AppController.getInstance());
    }
}
