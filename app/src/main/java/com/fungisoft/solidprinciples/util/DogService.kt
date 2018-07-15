package com.fungisoft.solidprinciples.util

import com.fungisoft.solidprinciples.util.models.PictureMessage
import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    fun randomImage() : Call<PictureMessage>
}