package com.fungisoft.solidprinciples.util.models

abstract class Pet(open val id: Int, open var name: String)

data class Cat(
        override val id: Int,
        override var name: String,
        val color: String,
        var isClean: Boolean
) : Pet(id, name) {
    fun clean() {
        isClean = true
    }
}

data class Dog(
        override val id: Int,
        override var name: String,
        val color: String
) : Pet(id, name)