package com.opoinf.laboratorio_opoinf.modulo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Dashboard") })
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            // Contenido de la pantalla del dashboard
            Text(text = "Contenido del dashboard", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    LaboratorioOpoinfTheme {
        DashboardScreen()
    }
}