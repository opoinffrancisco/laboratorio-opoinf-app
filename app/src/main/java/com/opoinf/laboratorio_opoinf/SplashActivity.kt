package com.opoinf.laboratorio_opoinf

import com.opoinf.laboratorio_opoinf.controlador.sesion.UserPreferences
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Puede agregar una vista aquí si lo desea, como una pantalla de bienvenida o un logotipo
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