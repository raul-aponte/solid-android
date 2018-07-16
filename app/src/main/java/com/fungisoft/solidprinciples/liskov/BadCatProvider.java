package com.fungisoft.solidprinciples.liskov;

import com.fungisoft.solidprinciples.util.PetProvider;
import com.fungisoft.solidprinciples.util.models.Cat;
import com.fungisoft.solidprinciples.util.models.Pet;

import org.jetbrains.annotations.NotNull;

public class BadCatProvider implements PetProvider {
    @NotNull
    @Override
    public Pet getPet() {
        Cat cat = new Cat(1, "Pelusa", "Blanco", false);

        if (cat.isClean()) {
            return null;
        }

        return cat;
    }
}
