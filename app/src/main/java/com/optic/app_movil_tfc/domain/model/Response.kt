package com.optic.gamermvvmapp.domain.model

import com.google.firebase.firestore.FirebaseFirestoreException

sealed class Response<out T> {
    object Loading: Response<Nothing>()
    data class Success<out T>(val data: T?): Response<T>()
    data class Failure<out T>(val exception: FirebaseFirestoreException?): Response<T>()
}
