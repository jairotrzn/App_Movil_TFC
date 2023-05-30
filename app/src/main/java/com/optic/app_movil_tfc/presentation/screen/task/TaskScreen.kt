package com.optic.app_movil_tfc.presentation.screen.task

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(navController : NavHostController){
    Scaffold(
        topBar = {},
        content = {
                  Text(text = "Segunda pantalla")
        },
        bottomBar = {}
    )
}