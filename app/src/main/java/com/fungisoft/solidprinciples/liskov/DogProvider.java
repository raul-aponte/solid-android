package com.fungisoft.solidprinciples.liskov;

import com.fungisoft.solidprinciples.util.PetProvider;
import com.fungisoft.solidprinciples.util.models.Dog;
import com.fungisoft.solidprinciples.util.models.Pet;

import org.jetbrains.annotations.NotNull;

public class DogProvider implements PetProvider {
    @NotNull
    @Override
    public Pet getPet() {
        return new Dog(1, "Chilaquil", "Cafe");
    }
}
