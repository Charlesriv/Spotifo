package com.example.spotifo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostMethod {
    @POST("")
    Call<MainActivity> sendUser(@Body User body);
}
