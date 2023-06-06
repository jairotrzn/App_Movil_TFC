package com.optic.app_movil_tfc.data.repository

import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestoreException
import com.optic.app_movil_tfc.core.Constants.MACHINES
import javax.inject.Inject
import javax.inject.Named
import com.optic.app_movil_tfc.core.Constants.PREVENTIV
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.repository.PreventivRepository
import com.optic.gamermvvmapp.domain.model.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await


class PreventivRepositoryImpl @Inject constructor(
    @Named(PREVENTIV) private val providePreventivRef: CollectionReference,
) : PreventivRepository {

    override fun getPreventiv(accessCode: String): Flow<Response<Preventiv>> = callbackFlow {
        val query = providePreventivRef.whereEqualTo("accessCode", accessCode)
        val snapshotListener = query.addSnapshotListener { snapshot, e ->
            val preventivResponse = if (snapshot != null && !snapshot.isEmpty) {
                val document = snapshot.documents.first()
                val preventiv = document.toObject(Preventiv::class.java)
                preventiv?.id = document.id
                Response.Success(preventiv)
            } else {
                Response.Failure(e)
            }
            trySend(preventivResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun updatePreventiv(preventiv: Preventiv): Flow<Response<Boolean>> = flow {
        try {
            val map: MutableMap<String,Any> = HashMap()
            map["accessCode"] = preventiv.accessCode
            map["color"] = preventiv.color
            map["namePersonInCharge"] = preventiv.namePersonInCharge
            map["password"] = preventiv.password
            map["start"] = preventiv.start
            map["state"] = preventiv.state
            map["student"] = preventiv.student
            map["tareas"] = preventiv.tareas

            providePreventivRef.document(preventiv.id).update(map).await()
            emit(Response.Success(true))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Response.Failure(e))
        }
    }
}