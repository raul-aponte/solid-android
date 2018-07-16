package com.fungisoft.solidprinciples.advice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

interface BadSecuredApiService {
    @GET("users/{id}")
    Call<User> fetchUser(
            @Header("user") String user,
            @Header("token") String token,
            @Path("id") String id
    );
}
