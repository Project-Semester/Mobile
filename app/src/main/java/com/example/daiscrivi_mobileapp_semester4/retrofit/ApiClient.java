package com.example.daiscrivi_mobileapp_semester4.retrofit;

import com.example.daiscrivi_mobileapp_semester4.Intereptor;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    private static String url = "http://localhost:8000/";






    public static Retrofit getRetrofit(String token) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Intereptor(token))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.100.246:8000/")
                .client(okHttpClient)
                .build();

return retrofit;
    }
public static UserService getUserService(String token){
        UserService userService = getRetrofit(token).create(UserService.class);
        return userService;
}
}
