package com.optic.app_movil_tfc.domain.repository

import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.gamermvvmapp.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PreventivRepository {

    fun getPreventiv(accessCode : String): Flow<Response<Preventiv>>
    suspend  fun updatePreventiv(preventiv: Preventiv): Flow<Response<Boolean>>
}