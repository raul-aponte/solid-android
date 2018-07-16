package com.fungisoft.solidprinciples.util

import com.fungisoft.solidprinciples.util.models.Pet

interface PetProvider {
    fun getPet() : Pet
}