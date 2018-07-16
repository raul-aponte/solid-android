package com.fungisoft.solidprinciples.liskov;

import com.fungisoft.solidprinciples.util.PetProvider;
import com.fungisoft.solidprinciples.util.models.Cat;
import com.fungisoft.solidprinciples.util.models.Pet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// objects in a program should be replaceable with instances of their subtypes
// without altering the correctness of that program
public class PetStore {
    private PetProvider petProvider;
    private List<Pet> pets;

    public PetStore() {
        petProvider = new BadCatProvider();
        //petProvider = new GoodCatProvider();
    }

    public void getPet(String newName) {
        Pet pet = petProvider.getPet();
        pet.setName(newName); // It explodes!!!
    }

    public void bad_getPet(String newName) {
        Pet pet = petProvider.getPet();
        if (pet instanceof Cat) {
            ((Cat) pet).clean();
        }
        pet.setName(newName);
    }

    public void createPets() {
        pets = new ArrayList<>();
        pets = new LinkedList<>();
    }

    public void addPet(Pet newPet) {
        pets.add(newPet); // Good LSP :)
    }
}
