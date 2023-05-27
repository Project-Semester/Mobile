package com.example.daiscrivi_mobileapp_semester4.retrofit;

import com.example.daiscrivi_mobileapp_semester4.Login.LoginRequest;
import com.example.daiscrivi_mobileapp_semester4.Login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);


}
