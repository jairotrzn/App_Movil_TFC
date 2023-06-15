package com.optic.app_movil_tfc.domain.repository

import com.optic.app_movil_tfc.domain.model.Fault
import com.optic.gamermvvmapp.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface FaultRepository {
    fun getFault(accessCode:String): Flow<Response<Fault>>
    suspend fun updateFault(fault: Fault): Response<Boolean>

}