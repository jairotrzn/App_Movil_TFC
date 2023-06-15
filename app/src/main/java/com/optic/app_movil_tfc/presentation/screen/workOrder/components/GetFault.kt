package com.optic.app_movil_tfc.presentation.screen.workOrder.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.CircularProgressIndicator
import com.optic.app_movil_tfc.presentation.screen.workOrder.WorkOrderViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun GetFault(
    viewModel: WorkOrderViewModel = hiltViewModel()
){
    when (val response = viewModel.faultResponse){
        Response.Loading -> {
            CircularProgressIndicator()
        }
        is Response.Success -> {
            viewModel.faultData = response.data!!
        }
        is Response.Failure->{
            Toast.makeText(LocalContext.current,"No se ha podido recuperar el Averia", Toast.LENGTH_LONG).show()
        }
    }
}

