package com.fungisoft.solidprinciples.util

import com.fungisoft.solidprinciples.util.models.PictureMessage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    fun fetchRandom(listener: PictureImageListener) {
        val service = retrofit.create(DogService::class.java)
        service.randomImage().enqueue(object : Callback<PictureMessage> {
            override fun onResponse(call: Call<PictureMessage>, response: Response<PictureMessage>) {
                listener.onImageReceived(response.body()?.message)
            }

            override fun onFailure(call: Call<PictureMessage>, t: Throwable) {

            }
        })
    }

    interface PictureImageListener {
        fun onImageReceived(imageUrl: String?)
    }
}