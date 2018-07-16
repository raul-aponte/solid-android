package com.fungisoft.solidprinciples.single;

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

// "A class should have only one reason to change."
public class GoodActivity extends Activity {
    private DogClient dogClient;
    @BindView(R.id.image_view_dog) ImageView imageViewDog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ButterKnife.bind(this);

        dogClient = new DogClient();
        dogClient.fetchRandom(new PictureImageListener() {
            @Override
            public void onImageReceived(String imageUrl) {
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
