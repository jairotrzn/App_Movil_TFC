package com.optic.app_movil_tfc.data.repository

import com.google.firebase.firestore.CollectionReference
import com.optic.app_movil_tfc.domain.model.Fault
import com.optic.app_movil_tfc.domain.repository.FaultRepository
import com.optic.gamermvvmapp.domain.model.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named
import com.optic.app_movil_tfc.core.Constants.FAULTS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await


class FaultRepositoryImpl @Inject constructor(
    @Named(FAULTS) private val provideFaultRef:CollectionReference
): FaultRepository {
    override fun getFault(accessCode: String): Flow<Response<Fault>> = callbackFlow{
        val query = provideFaultRef.whereEqualTo("accessCode",accessCode)
        val snapshotListener = query.addSnapshotListener{ snapshot , e ->
            val faultResponse = if (snapshot != null && !snapshot.isEmpty){
                val document = snapshot.documents.first()
                val fault = document.toObject(Fault::class.java)
                fault?.id = document.id
                Response.Success(fault)
            }else {
                Response.Failure(e)
            }
            trySend(faultResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun updateFault(fault: Fault): Flow<Response<Boolean>> = flow {
            try {
                val map: MutableMap<String,Any> = HashMap()
                map["state"] = "Finalizado"
                map["solution"] = fault.state

                provideFaultRef.document(fault.id).update(map).await()
                emit(Response.Success(true))
            }catch (e: Exception){
                e.printStackTrace()
                emit(Response.Failure(e))
            }
    }

}

