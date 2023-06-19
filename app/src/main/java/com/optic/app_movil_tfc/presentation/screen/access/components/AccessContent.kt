package com.optic.app_movil_tfc.presentation.screen.access.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.R
import com.optic.app_movil_tfc.presentation.screen.access.AccessViewModel
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import com.optic.app_movil_tfc.ui.theme.logoColor

@Composable
fun AccessContent(
    navController: NavHostController,
    viewModel: AccessViewModel = hiltViewModel() ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            AccessCodeTextField(viewModel)
            AccessButton(viewModel,navController)
        }
    }

@Composable
fun Logo(){
    Image(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.logo_proyecto),
        contentDescription = "Logo",
    )
}

@Composable
fun AccessCodeTextField(viewModel: AccessViewModel) {
    TextField(
        modifier = Modifier.padding(top = 30.dp),
        value = viewModel.state.accessCode,
        onValueChange = { viewModel.accessCodeChange(it)},
        label = { Text(text = "Código de Acceso") },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = ""
            )
        }
    )
}

@Composable
fun AccessButton(
    viewModel: AccessViewModel,
    navController: NavHostController
) {
    Button(
        modifier = Modifier
            .padding(top = 10.dp, start = 20.dp),
        onClick = {
            navController.navigate("preventivs/${viewModel.state.accessCode}")
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = logoColor,
            contentColor = Color.White
        )
    ) {
        Text(text = "Aceptar")
    }
}

