package com.fungisoft.solidprinciples.open;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fungisoft.solidprinciples.util.PetProvider;
import com.fungisoft.solidprinciples.util.models.Pet;

// Software entities (classes, modules, functions, etc.) should be open for extension,
// but closed for modification
public class GoodActivity extends BaseActivity {
    private PetProvider petProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pet pet = petProvider.getPet();
        showPet(pet);
    }

    private void showPet(Pet pet) {
        GoodPetView view = getCurrentView();
        view.showPet(pet);
    }
}
