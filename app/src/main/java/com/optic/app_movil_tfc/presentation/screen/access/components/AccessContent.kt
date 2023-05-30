package com.optic.app_movil_tfc.presentation.screen.access.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.R
import com.optic.app_movil_tfc.presentation.navigation.AppScreen
import com.optic.app_movil_tfc.presentation.screen.access.AccessViewModel


@Composable
fun AccessContent(
    navController: NavHostController,
    viewModel: AccessViewModel = hiltViewModel()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            AccessCodeTextFiel(viewModel)
            PasswordTexteField(viewModel)
            AccessButtom(navController)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessCodeTextFiel(viewModel: AccessViewModel){
    OutlinedTextField(
        modifier = Modifier.padding(top=30.dp),
        value = viewModel.email.value,
        onValueChange = {viewModel.email.value = it },
        label = {
            Text(text = " Código de Acceso")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Check,
                contentDescription = "")
        }
        )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTexteField(viewModel: AccessViewModel){
    OutlinedTextField(

        modifier = Modifier.padding(20.dp),
        value = viewModel.password.value,
        onValueChange = {viewModel.password.value = it},
        label = {
            Text(text = "Password")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription ="" )
        },

    )
}

@Composable
fun AccessButtom(navController : NavHostController){

    Button(
        modifier = Modifier.padding(
            top=10.dp,
            start = 30.dp
        ),
        onClick = {
                  navController.navigate(route = AppScreen.Tasks.rute)
        },
    ) {
        Text(text = "Aceptar")
    }
}
