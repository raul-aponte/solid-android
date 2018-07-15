package com.fungisoft.solidprinciples.single;

import android.app.Activity;

import com.fungisoft.solidprinciples.util.Constants;
import com.fungisoft.solidprinciples.util.DogService;
import com.fungisoft.solidprinciples.util.models.PictureMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BadParentActivity extends Activity {
    protected final void fetchPicture() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DogService service = retrofit.create(DogService.class);
        service.randomImage().enqueue(new Callback<PictureMessage>() {
            @Override
            public void onResponse(Call<PictureMessage> call, Response<PictureMessage> response) {
                setPicture(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<PictureMessage> call, Throwable t) {

            }
        });
    }

    protected abstract void setPicture(String imageUrl);
}
