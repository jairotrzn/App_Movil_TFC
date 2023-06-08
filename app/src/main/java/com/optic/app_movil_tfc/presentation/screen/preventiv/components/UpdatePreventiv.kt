package com.optic.app_movil_tfc.presentation.screen.preventiv.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.CircularProgressIndicator
import com.optic.app_movil_tfc.presentation.screen.preventiv.PreventivViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun UpDataPreventiv(
    viewModel: PreventivViewModel = hiltViewModel()
){
    when (val response = viewModel.updatePreventivResponse){
        Response.Loading -> {
            CircularProgressIndicator()
        }
        is Response.Success -> {
            Toast.makeText(LocalContext.current,"Preventivo finalizado", Toast.LENGTH_LONG).show()

        }
        is Response.Failure->{
            Toast.makeText(LocalContext.current,"No se ha podido modificar", Toast.LENGTH_LONG).show()
        }
    }
}