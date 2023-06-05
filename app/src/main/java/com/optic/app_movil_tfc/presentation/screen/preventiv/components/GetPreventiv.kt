package com.optic.app_movil_tfc.presentation.screen.preventiv.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

import com.optic.app_movil_tfc.presentation.screen.preventiv.PreventivViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun GetPreventiv(
    viewModel: PreventivViewModel = hiltViewModel()
){
    when (val response = viewModel.preventivResponse){
        Response.Loading -> {

        }
        is Response.Success -> {
            PreventivContent(viewModel.preventivData!!)
        }
        is Response.Success->{
         //   Toast.makeText(LocalContext,"Ha ocurrido un error",Toast.LENGTH_SHORT).show
        }
    }
}