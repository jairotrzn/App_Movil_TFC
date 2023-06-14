package com.optic.app_movil_tfc.presentation.screen.access

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccessViewModel @Inject constructor(
    private val preventivUseCase: PreventivUseCase
) : ViewModel() {

   var state by mutableStateOf(AccessStates())
    private set

    //Response
    var preventivResponse by mutableStateOf<Response<Preventiv>?>(null)

    fun accessCodeChange(accessCode: String) {
        state = state.copy(accessCode = accessCode)
    }

}







