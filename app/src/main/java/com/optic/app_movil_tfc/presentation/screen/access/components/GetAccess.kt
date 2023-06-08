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

            if (viewModel.comparePassword(response.data!!.password)){
                navHostController.navigate("preventivs/${response.data!!.accessCode}")
            }else{
                viewModel.errorVisible.value = true
            }
        }
        is Response.Failure->{
            Toast.makeText(LocalContext.current,"No se ha podido acceder ", Toast.LENGTH_LONG).show()
        }
    }
}