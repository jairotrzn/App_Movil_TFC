package com.optic.app_movil_tfc.presentation.screen.workOrder

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.app_movil_tfc.domain.model.Fault
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.fault.FaultUseCase
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkOrderViewModel @Inject constructor(

    private val faultUseCase: FaultUseCase,
    private val preventivUseCase: PreventivUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(WorkOrderStates())
        private set
    var preventivData by mutableStateOf(Preventiv())
    var faultData by mutableStateOf(Fault())

    var accessCode = savedStateHandle.get<String>("accessCode")

    //Response
    var preventivResponse by mutableStateOf<Response<Preventiv>?>(null)
    var updatePreventivResponse by mutableStateOf<Response<Boolean>?>(null)

    var faultResponse by mutableStateOf<Response<Fault>?>(null)
    var updateFaultResponse by mutableStateOf<Response<Boolean>?>(null)

    init {
        getPreventivByAccessCode()

    }

    private fun getPreventivByAccessCode() = viewModelScope.launch {

        preventivResponse = Response.Loading
        preventivUseCase.getPreventiv(accessCode!!).collect { response ->
            preventivResponse = response
        }

    }

    fun getFaultByAccessCode() = viewModelScope.launch {

        faultResponse = Response.Loading
        faultUseCase.getFault(accessCode!!).collect { response ->
            faultResponse = response
        }
    }

    fun solutionChange(accessCode: String) {
        state = state.copy(solution = accessCode)
    }

    fun onUpdatePreventiv() {
        Log.d("updatePrev", "Voy a crear el objeto")
        var preventiv = Preventiv(
            id = preventivData!!.id,
            finish = true
        )
        upDate(preventiv)
    }

    fun onUpdateFault() {


        var fault = Fault(
            id = faultData!!.id,
            solution = state.solution,
            finish = true
        )
        updateFault(fault)
    }

    private fun updateFault(fault: Fault)= viewModelScope.launch {
        updateFaultResponse = Response.Loading
        val result = faultUseCase.updateFault(fault)
        updateFaultResponse = result
    }


    private fun upDate(preventiv: Preventiv) = viewModelScope.launch {
        updatePreventivResponse = Response.Loading
        val result = preventivUseCase.updatePreventiv(preventiv)
        updatePreventivResponse = result
    }

}






