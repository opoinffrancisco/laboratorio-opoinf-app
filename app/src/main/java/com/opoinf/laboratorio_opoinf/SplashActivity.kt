package com.opoinf.laboratorio_opoinf

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.opoinf.laboratorio_opoinf.controlador.sesion.UserPreferences
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioOpoinfTheme {
                SplashScreen()
            }
        }

        // Verificar la sesión
        lifecycleScope.launch {
            // Obtener el token de sesión desde el DataStore
            val token = UserPreferences.getToken(this@SplashActivity).first()

            if (token.isNullOrEmpty()) {
                // Redirigir a LoginActivity si no hay token
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            } else {
                // Redirigir a MainActivity si hay token
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
            // Finalizar SplashActivity para que no se quede en la pila de actividades
            finish()
        }
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_splash), // Reemplaza con el nombre de tu imagen
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    LaboratorioOpoinfTheme {
        SplashScreen()
    }
}
