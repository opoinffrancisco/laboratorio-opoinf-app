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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme

class ResetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioOpoinfTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ResetPasswordScreen(
                        onResetPassword = { code, newPassword ->
                            // Lógica para cambiar la contraseña con el servidor
                            // Simulación de éxito
                            Toast.makeText(this, "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ResetPasswordScreen(onResetPassword: (String, String) -> Unit) {
    var code by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = code,
            onValueChange = { code = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            decorationBox = { innerTextField ->
                if (code.isEmpty()) {
                    Text(text = stringResource(R.string.codigo_de_recuperacion), color = MaterialTheme.colorScheme.onBackground)
                }
                innerTextField()
            }
        )
        BasicTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                if (newPassword.isEmpty()) {
                    Text(text = stringResource(R.string.nueva_contrasena), color = MaterialTheme.colorScheme.onBackground)
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
                    Text(text = context.getString(R.string.confirmar_contrasena), color = MaterialTheme.colorScheme.onBackground)
                }
                innerTextField()
            }
        )
        Button(
            onClick = {
                if (newPassword == confirmPassword) {
                    onResetPassword(code, newPassword)
                } else {
                    Toast.makeText(context,
                        context.getString(R.string.las_contrasenas_no_coinciden), Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = stringResource(R.string.cambiar_contrasena))
        }
    }
}
