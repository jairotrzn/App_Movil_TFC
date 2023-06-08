package com.optic.app_movil_tfc.presentation.screen.access

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccessViewModel @Inject constructor(
    private val preventivUseCase: PreventivUseCase
) : ViewModel() {

    val errorVisible: MutableState<Boolean> = mutableStateOf(false)
    var accessCode: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var preventivResponse by mutableStateOf<Response<Preventiv>?>(null)
    var preventivData: Preventiv? = null



    fun getPreventivByAccessCode() = viewModelScope.launch {
        preventivResponse = Response.Loading
        preventivUseCase.getPreventiv(accessCode.value).collect() { response ->
            preventivResponse = response

        }
    }

    fun comparePassword(passwordPreventiv: String): Boolean {
        return this.password.value == passwordPreventiv
    }
}







