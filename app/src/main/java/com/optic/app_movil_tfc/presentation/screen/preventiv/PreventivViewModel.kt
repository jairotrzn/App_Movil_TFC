package com.optic.app_movil_tfc.presentation.screen.preventiv

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.model.Repuesto
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreventivViewModel @Inject constructor(
    private val preventivUseCase: PreventivUseCase,
) : ViewModel() {
    var preventivData: Preventiv? = null
    var preventivResponse by mutableStateOf<Response<Preventiv>?>(null)

    var namePersonInCharge: MutableState<String> = mutableStateOf("")
    var student: MutableState<String> = mutableStateOf("")



    init {
        getPreventivByAccessCode()
    }

    private fun getPreventivByAccessCode() = viewModelScope.launch {
        preventivResponse = Response.Loading
        preventivUseCase.getPreventiv("09e179").collect { response ->
            preventivResponse = response

            if (response is Response.Success) {
                preventivData = response.data
                namePersonInCharge.value = preventivData!!.namePersonInCharge
                student.value = preventivData!!.student
            }
        }
    }

}