package com.uvg.laboratorio7.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uvg.laboratorio7.Navigation.AppScreens
import com.uvg.laboratorio7.R
import com.uvg.laboratorio7.ui.theme.Laboratorio7Theme

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit){
    LoginBodyContent(onLoginSuccess = onLoginSuccess)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBodyContent(onLoginSuccess: () -> Unit){
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )
        Spacer(
            modifier = Modifier
                .height(18.dp)
        )
        Divider(
            modifier = Modifier
                .width(200.dp)
        )
        Spacer(
            modifier = Modifier
                .height(18.dp)
        )
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(R.string.usuario_Label)) },
            placeholder = { Text(stringResource(R.string.nombre_de_usuario))},
            singleLine = true
        )
        Spacer(
            modifier = Modifier
            .height(36.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.contrase_a_label)) },
            placeholder = { Text(stringResource(R.string.contrase_a))},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(
            modifier = Modifier
                .height(36.dp)
        )
        Button(
            onClick = {
                if (isValidCredentials(username, password)) {
                    onLoginSuccess()
                }
                      },
            modifier = Modifier
                .width(200.dp),
        ) {
            Text(stringResource(R.string.login_titel))
        }
    }
}



fun isValidCredentials(username: String, password: String): Boolean {
    val localUsername = "admin"
    val localPassword = "admin"

    return username == localUsername && password == localPassword
}