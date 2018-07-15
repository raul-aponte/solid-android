package com.fungisoft.solidprinciples.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.fungisoft.solidprinciples.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BadChildActivity extends BadParentActivity {
    @BindView(R.id.image_view_dog) ImageView imageViewDog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);
        ButterKnife.bind(this);

        fetchPicture();
    }

    @Override
    protected void setPicture(String imageUrl) {
        if (imageUrl.isEmpty()) return;
        Picasso.get()
                .load(imageUrl)
                .into(imageViewDog);
    }
}
