package com.opoinf.laboratorio_opoinf

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioOpoinfTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ForgotPasswordScreen(

                        onBackToLogin = {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()  // Para cerrar la actividad de registro y no tenerla en la pila de actividades
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ForgotPasswordScreen(onBackToLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            decorationBox = { innerTextField ->
                if (email.isEmpty()) {
                    Text(text = "Correo electrónico", color = MaterialTheme.colorScheme.onBackground)
                }
                innerTextField()
            }
        )
        Button(
            onClick = {
                // Lógica para recuperar la contraseña
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Recuperar Contraseña")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            onClick = onBackToLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Volver al inicio de sesión")
        }
    }
}