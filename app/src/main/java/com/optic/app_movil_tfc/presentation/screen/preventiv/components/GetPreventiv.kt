package com.optic.app_movil_tfc.presentation.screen.preventiv.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.CircularProgressIndicator
import com.optic.app_movil_tfc.presentation.screen.preventiv.PreventivViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun GetPreventiv(
    viewModel: PreventivViewModel = hiltViewModel()
){
    when (val response = viewModel.preventivResponse){
        Response.Loading -> {
            CircularProgressIndicator()
        }
        is Response.Success -> {
            PreventivContent(preventiv = response.data!!)
        }
        is Response.Failure->{
            Toast.makeText(LocalContext.current,"No se ha podido recuperar el preventivo",Toast.LENGTH_LONG).show()
        }
    }
}

