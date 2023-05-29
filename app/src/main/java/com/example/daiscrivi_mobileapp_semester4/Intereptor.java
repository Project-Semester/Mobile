package com.example.daiscrivi_mobileapp_semester4;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class Intereptor implements Interceptor {
    private String accessToken;

    public Intereptor(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .build();
        return chain.proceed(request);
    }
}
