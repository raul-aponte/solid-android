package com.fungisoft.solidprinciples.single;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.fungisoft.solidprinciples.R;
import com.fungisoft.solidprinciples.util.models.Constants;
import com.fungisoft.solidprinciples.util.models.DogService;
import com.fungisoft.solidprinciples.util.models.PictureMessage;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// "A class should have only one reason to change."
public class BadActivity extends Activity {
    @BindView(R.id.image_view_dog) ImageView imageViewDog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DogService service = retrofit.create(DogService.class);
        service.randomImage().enqueue(new Callback<PictureMessage>() {
            @Override
            public void onResponse(Call<PictureMessage> call, Response<PictureMessage> response) {
                setPicture(response.body());
            }

            @Override
            public void onFailure(Call<PictureMessage> call, Throwable t) {

            }
        });
    }

    private void setPicture(PictureMessage message) {
        String imageUrl = message.getMessage();
        if (imageUrl.isEmpty()) return;
        Picasso.get()
                .load(imageUrl)
                .into(imageViewDog);
    }
}
