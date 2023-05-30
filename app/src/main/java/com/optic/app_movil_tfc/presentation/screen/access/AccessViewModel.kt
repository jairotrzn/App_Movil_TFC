package com.optic.app_movil_tfc.presentation.screen.access

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccessViewModel @Inject constructor() : ViewModel() {
    var email : MutableState<String> = mutableStateOf("")
    var password : MutableState<String> = mutableStateOf("")
}