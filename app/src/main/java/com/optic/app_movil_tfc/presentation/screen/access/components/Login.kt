package com.optic.app_movil_tfc.presentation.screen.access.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.presentation.screen.access.AccessViewModel
import com.optic.gamermvvmapp.domain.model.Response

@Composable
fun Login(
    navController: NavHostController, viewModel: AccessViewModel = hiltViewModel()
) {
    when (val loginResponse = viewModel.preventivResponse) {
        Response.Loading -> {
            LaunchedEffect(Unit) {
                viewModel.navegacion(navController)
            }
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                "Codigo de aceeso o contraseña incorrecto",
                Toast.LENGTH_LONG
            ).show()
        }

    }
}