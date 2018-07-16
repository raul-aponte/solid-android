package com.fungisoft.solidprinciples.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.fungisoft.solidprinciples.R;
import com.fungisoft.solidprinciples.util.DogClient;
import com.fungisoft.solidprinciples.util.PictureImageListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

// A. High-level modules should not depend on low-level modules. Both should depend on abstractions.
// B. Abstractions should not depend on details. Details should depend on abstractions.
public class BadActivity extends Activity {
    private DogClient dogClient;
    @BindView(R.id.image_view_dog) ImageView imageViewDog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);
        ButterKnife.bind(this);

        dogClient = new DogClient();
        dogClient.fetchRandom(new PictureImageListener() {
            @Override
            public void onImageReceived(@Nullable String imageUrl) {
                showImage(imageUrl);
            }
        });
    }

    private void showImage(String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) return;
        Picasso.get()
                .load(imageUrl)
                .error(android.R.drawable.stat_notify_error)
                .into(imageViewDog);
    }
}
