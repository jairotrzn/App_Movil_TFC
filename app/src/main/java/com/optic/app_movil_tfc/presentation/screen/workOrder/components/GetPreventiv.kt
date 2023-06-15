package com.optic.app_movil_tfc.presentation.screen.workOrder.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.CircularProgressIndicator
import com.optic.app_movil_tfc.presentation.screen.workOrder.WorkOrderViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun GetPreventiv(
    viewModel: WorkOrderViewModel = hiltViewModel()){
    when (val response = viewModel.preventivResponse){
        Response.Loading -> {

            CircularProgressIndicator()
        }
        is Response.Success -> {
                viewModel.preventivData = response.data!!

        }
        is Response.Failure->{
            viewModel.getFaultByAccessCode()
        }
    }
}

