package com.opoinf.laboratorio_opoinf

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioOpoinfTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LoginScreen(
                        onLogin = { email, password ->
                            if (email == "user@example.com" && password == "password") {
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, getString(R.string.credenciales_incorrectas), Toast.LENGTH_SHORT).show()
                            }
                        },
                        onForgotPassword = {
                            // Redirigir a ForgotPasswordActivity (crear esta actividad)
                            val intent = Intent(this, ForgotPasswordActivity::class.java)
                            startActivity(intent)
                        },
                        onRegister = {
                            // Redirigir a RegisterActivity (crear esta actividad)
                            val intent = Intent(this, RegisterActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(onLogin: (String, String) -> Unit, onForgotPassword: () -> Unit, onRegister: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                    Text(text = stringResource(R.string.correo_electronico), color = MaterialTheme.colorScheme.onBackground)
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
                    Text(text = stringResource(R.string.contrasena), color = MaterialTheme.colorScheme.onBackground)
                }
                innerTextField()
            }
        )
        Button(
            onClick = { onLogin(email, password) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = stringResource(R.string.login))
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onForgotPassword) {
            Text(text = stringResource(R.string.recuperar_contrasena))
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = onRegister) {
            Text(text = stringResource(R.string.registrarse))
        }
    }
}