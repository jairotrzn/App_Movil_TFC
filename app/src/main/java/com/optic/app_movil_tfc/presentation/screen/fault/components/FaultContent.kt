package com.optic.app_movil_tfc.presentation.screen.fault.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.optic.app_movil_tfc.domain.model.Fault


@Composable
fun FaultContent(
    fault: Fault
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputSection(fault)
        FaultDescriptionSection(fault)
        FaultSolutionSection(fault)
    }
}

@Composable
fun InputSection(fault: Fault) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            modifier = Modifier.padding(15.dp),
            value = fault.namePersonInCharge,
            onValueChange = { },
            label = {
                Text(text = "Responsable")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
            },
            enabled = false
        )

        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = fault.student,
            onValueChange = { },
            label = {
                Text(text = "Alumno")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Face, contentDescription = "")
            },
            enabled = false
        )
    }
}

@Composable
fun FaultDescriptionSection(fault:Fault){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Descripción de la averia")
            TextField(
                value = fault.description,
                onValueChange = {},
                modifier = Modifier.padding(top = 8.dp),
            )

        }
    }
}



@Composable
fun FaultSolutionSection(fault: Fault){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Descripción de la solución aplicada")
            TextField(
                value = fault.solution,
                onValueChange = { fault.solution = it },
                modifier = Modifier.padding(top = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                maxLines = 5,
            )
        }
    }
}
