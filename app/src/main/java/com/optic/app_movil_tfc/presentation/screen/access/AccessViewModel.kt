package com.optic.app_movil_tfc.presentation.screen.access

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccessViewModel @Inject constructor(
    private val preventivUseCase: PreventivUseCase
) : ViewModel() {
    var accessCode: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var preventivRespose  by mutableStateOf<Response<Preventiv>?>(null)


    private val _preventiv: MutableState<Response<Preventiv>?> = mutableStateOf(null)
    val preventiv: State<Response<Preventiv>?> get() = _preventiv

    init {
        getPreventivByAccessCode()
    }

    fun getPreventivByAccessCode() = viewModelScope.launch {

            preventivRespose = Response.Loading
            preventivUseCase.getPreventiv("fb75ec").collect(){
                response -> preventivRespose

                try {
                    if (response is Response.Success) {
                        val preventivData = response.data
                        password.value = preventivData!!.accessCode

                    }
                }catch (e:Exception){
                    println(e.stackTrace)
                }

            }

        }

}
