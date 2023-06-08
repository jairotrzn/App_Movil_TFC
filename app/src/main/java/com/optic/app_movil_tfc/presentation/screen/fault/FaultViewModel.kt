package com.optic.app_movil_tfc.presentation.screen.fault

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.app_movil_tfc.domain.model.Fault
import com.optic.app_movil_tfc.domain.use_case.fault.FaultUseCase
import com.optic.gamermvvmapp.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FaultViewModel @Inject constructor(
    private val providePreventivsUseCase: FaultUseCase
) : ViewModel() {
    var faultResponse by mutableStateOf<Response<Fault>?>(null)
    var faultData: Fault? = null

    var solution by mutableStateOf<String>("")

    var updateFaultResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    init {
        getFaultByAccessCode()
    }

    fun getFaultByAccessCode() = viewModelScope.launch {
        faultResponse = Response.Loading
        providePreventivsUseCase.getFault("").collect { response ->
            faultResponse = response
        }
    }

    fun updateFault() {
        var fault = Fault(
            id = faultData!!.id,
            accessCode = faultData!!.accessCode,
            color = faultData!!.color,
            description = faultData!!.description,
            end = faultData!!.end,
            machineCode = faultData!!.machineCode,
            namePersonInCharge = faultData!!.namePersonInCharge,
            password = faultData!!.password,
            solution = faultData!!.solution,
            start = faultData!!.start,
            state = faultData!!.state,
            student = faultData!!.student
        )
        update(fault)
    }

    private fun update(fault: Fault) = viewModelScope.launch{
        updateFaultResponse = Response.Loading
        providePreventivsUseCase.updateFault(fault).collect{ response ->
            updateFaultResponse = response

        }
    }


}

