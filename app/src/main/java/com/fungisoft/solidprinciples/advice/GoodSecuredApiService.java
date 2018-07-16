package com.fungisoft.solidprinciples.advice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GoodSecuredApiService {
    @GET("users/{id}")
    Call<User> fetchUser(
            @Path("id") String id
    );
}
