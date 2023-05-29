package com.example.daiscrivi_mobileapp_semester4.retrofit;

import com.example.daiscrivi_mobileapp_semester4.Models.response.StoriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface StoriesApi {

    @GET("api/stories")
    Call<StoriesResponse> getStories();
}
