package com.optic.app_movil_tfc.presentation.screen.access

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.app_movil_tfc.presentation.navigation.AppScreen
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


    init {
        getPreventivByAccessCode()
    }

    fun confirmAccess(navController: NavHostController){
        getPreventivByAccessCode()
      if(comparePassword()){
          navegacion(navController)
      }else{
          errorVisible.value = true
      }
    }
    fun getPreventivByAccessCode() = viewModelScope.launch {
        preventivResponse = Response.Loading
        preventivUseCase.getPreventiv(accessCode.value).collect { response ->
            preventivResponse = response

            if (response is Response.Success) {
                preventivData = response.data


            }
        }
    }

    fun comparePassword(): Boolean {
        return password.value == preventivData?.password
    }

        fun navegacion(navController: NavHostController) {
                navController.navigate(route = AppScreen.Tasks.rute)
        }

    }



