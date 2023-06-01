package com.optic.app_movil_tfc.presentation.screen.preventiv

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import kotlinx.coroutines.launch
import javax.inject.Inject


class PreventivViewModel @Inject constructor(
    private val preventivUseCase : PreventivUseCase,
):ViewModel(){
    var preventivData: Preventiv? = null
    var preventivResponse by mutableStateOf<Response<Preventiv>?>(null)

    init {
        getPreventivByAccessCode()
    }

    fun getPreventivByAccessCode() = viewModelScope.launch {
        preventivResponse = Response.Loading
        preventivUseCase.getPreventiv("09e179").collect { response ->
            preventivResponse = response

            if (response is Response.Success) {
                preventivData = response.data
            }
        }
    }
}
