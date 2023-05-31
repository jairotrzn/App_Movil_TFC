package com.optic.app_movil_tfc.data.repository

import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestoreException
import com.optic.app_movil_tfc.core.Constants.MACHINES
import javax.inject.Inject
import javax.inject.Named
import com.optic.app_movil_tfc.core.Constants.PREVENTIV
import com.optic.app_movil_tfc.domain.model.Machine
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.repository.PreventivRepository
import com.optic.gamermvvmapp.domain.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.File


class PreventivRepositoryImpl @Inject constructor(
    @Named(PREVENTIV) private val providePreventivRef : CollectionReference,
    @Named(MACHINES) private val provideMachineRef : CollectionReference,
): PreventivRepository{

    override fun getPreventiv(accessCode: String): Flow<Response<Preventiv>> = callbackFlow {
        val snapshotListener = providePreventivRef.whereEqualTo("accessCode", accessCode).addSnapshotListener { snapshot, e ->
            val preventivResponse = if (snapshot != null) {
                val preventiv = snapshot.toObjects(Preventiv::class.java)
                snapshot.documents.forEachIndexed { index, document ->
                    preventiv[index].id = document.id
                }
                Response.Success(preventiv.firstOrNull())
            } else {
                Response.Failure(e)
            }
            trySend(preventivResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun update(preventiv: Preventiv, file: File?): Response<Boolean> {
        TODO("Not yet implemented")
    }
}