package com.optic.app_movil_tfc.presentation.screen.preventiv.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.ui.theme.CardColor
import com.optic.app_movil_tfc.ui.theme.Purple500


@Composable
fun PreventivContent(
    preventiv: Preventiv
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputSection(preventiv)
        CardList(preventiv)
    }
}

@Composable
fun InputSection(preventiv: Preventiv) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            modifier = Modifier.padding(15.dp),
            value = preventiv.namePersonInCharge,
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
            value = preventiv.student,
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
fun CardList(preventiv: Preventiv) {

    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = preventiv.tareas
        ) { Task ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = CardColor),
                elevation = 4.dp,

            ) {

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(

                        text = Task.name,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = "Procedimiento")
                    Task.datos.forEach { dato ->

                        Text(text = "  - $dato")
                    }
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = "Repuestos:")
                    Task.repuestos.forEachIndexed { index, repuesto ->

                        Text(text = "    ID de repuesto: ${repuesto.idRepuesto}")
                        Text(text = "    Nombre: ${repuesto.name}")
                        Spacer(modifier = Modifier.height(8.dp))
                    }


                }

            }

        }
    }
}



