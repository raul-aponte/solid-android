package com.fungisoft.solidprinciples.util

interface DogProvider {
    fun fetchRandom(listener: PictureImageListener)
}

interface PictureImageListener {
    fun onImageReceived(imageUrl: String?)
}
