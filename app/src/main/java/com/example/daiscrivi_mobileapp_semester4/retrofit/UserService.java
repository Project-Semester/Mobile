package com.example.daiscrivi_mobileapp_semester4.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);


}
