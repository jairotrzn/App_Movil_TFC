package com.optic.app_movil_tfc.presentation.screen.access

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.presentation.screen.access.components.AccessContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccessScreen(navController:NavHostController) {
    Scaffold(
        topBar = {},
        content = {
            AccessContent(navController)
        },
        bottomBar = {

        }
    )


}
