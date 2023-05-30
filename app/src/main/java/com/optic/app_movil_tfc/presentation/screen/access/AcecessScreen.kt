package com.optic.app_movil_tfc.presentation.screen.access

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.presentation.screen.access.components.AccessContent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccessScreen(navController:NavHostController) {
    Scaffold(
        topBar = {},
        content = {
            AccessContent(navController)
        },
        bottomBar = {}
    )
}
