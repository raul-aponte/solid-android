package com.fungisoft.solidprinciples.open;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.fungisoft.solidprinciples.util.PetProvider;
import com.fungisoft.solidprinciples.util.models.Cat;
import com.fungisoft.solidprinciples.util.models.Dog;
import com.fungisoft.solidprinciples.util.models.Pet;

// Software entities (classes, modules, functions, etc.) should be open for extension,
// but closed for modification
public class BadActivity extends BaseActivity {
    private PetProvider petProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pet pet = petProvider.getPet();
        showPet(pet);
    }

    private void showPet(Pet pet) {
        Fragment fragment = getCurrentFragment();
        if (fragment instanceof BadDogFragment) {
            ((BadDogFragment) fragment).showDog((Dog) pet);
        } else if (fragment instanceof BadCatFragment) {
            ((BadCatFragment) fragment).showCat((Cat) pet);
        }
    }
}
