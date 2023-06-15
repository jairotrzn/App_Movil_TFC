package com.optic.app_movil_tfc.presentation.screen.access.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.material.CircularProgressIndicator
import com.optic.app_movil_tfc.presentation.screen.access.AccessViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun GetAccess(
    viewModel: AccessViewModel = hiltViewModel(),
    navHostController: NavHostController
){
    when (val response = viewModel.preventivResponse){
        Response.Loading -> {
            CircularProgressIndicator()
        }
        is Response.Success -> {

            Toast.makeText(LocalContext.current,"Estoy comprobando el estado de e get Acess ", Toast.LENGTH_LONG).show()
            //navController.navigate("preventivs/${viewModel.accessCode.value}")

        }
        is Response.Failure->{
            Toast.makeText(LocalContext.current,"No se ha podido acceder no hay datos", Toast.LENGTH_LONG).show()
        }
    }
}