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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioOpoinfTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RegisterScreen(
                        onRegister = {
                            // Lógica para registrar el usuario
                        },
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
fun RegisterScreen(onRegister: () -> Unit, onBackToLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                if (password.isEmpty()) {
                    Text(text = "Contraseña", color = MaterialTheme.colorScheme.onBackground)
                }
                innerTextField()
            }
        )
        BasicTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                if (confirmPassword.isEmpty()) {
                    Text(text = "Confirmar contraseña", color = MaterialTheme.colorScheme.onBackground)
                }
                innerTextField()
            }
        )
        Button(
            onClick = onRegister,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Registrarse")
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