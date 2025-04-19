package com.nsu.cityadvertisement.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.nsu.cityadvertisement.ui.theme.CityAdvertisementTheme


@Composable
fun LoginScreen(paddingValues: PaddingValues) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold);

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    text = if (emailError.isNotEmpty()) emailError else "Email",
                    color = if (emailError.isNotEmpty()) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Rounded.AccountCircle,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp,horizontal = 20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = if (passwordError.isNotEmpty()) passwordError else "Password",
                    color = if (emailError.isNotEmpty()) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Rounded.Lock,
                    contentDescription = ""
                )
            },
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                Icon(
                    imageVector = image,
                    contentDescription = null,
                    modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                )

            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                emailError = if (email.isBlank()) "Email is required" else ""
                passwordError = if (password.isBlank()) "Password is required" else ""
                if (email.isEmpty() && password.isEmpty()){
                    //login logic
                }
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 90.dp)
        ) {
            Text( text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text( text = "Forget password?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { //some logic
            })

        Spacer(modifier = Modifier.height(16.dp))

        Text( text = "Not with us? Sign Up",
            color = MaterialTheme.colorScheme.primary,
            modifier =  Modifier.clickable { //some registration logic
            })
    }

}

@Preview
@Composable
fun PreviewLoginScreen() {
    CityAdvertisementTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LoginScreen(paddingValues = innerPadding)
        }
    }
}