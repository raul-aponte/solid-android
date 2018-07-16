package com.fungisoft.solidprinciples.dependency;

import com.fungisoft.solidprinciples.util.DogProvider;
import com.fungisoft.solidprinciples.util.PictureImageListener;

import org.jetbrains.annotations.NotNull;

public class FileDogProvider implements DogProvider {
    @Override
    public void fetchRandom(@NotNull PictureImageListener listener) {
        // Return Dog from File
        listener.onImageReceived("https://images.dog.ceo/breeds/husky/n02110185_2728.jpg");
    }
}
