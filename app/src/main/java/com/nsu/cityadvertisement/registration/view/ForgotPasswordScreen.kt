package com.nsu.cityadvertisement.registration.view

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nsu.cityadvertisement.R
import com.nsu.cityadvertisement.ui.theme.CityAdvertisementTheme

@Composable
fun ForgetPasswordScreen(navController: NavController, paddingValues: PaddingValues) {

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.forgot_password))
    val progress by animateLottieCompositionAsState(
        isPlaying = true,
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = 0.7f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(modifier = Modifier
            .size(200.dp)
            .align(Alignment.CenterHorizontally),
            composition = composition,
            progress = { progress })

        Text(
            text = "Forget password",
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, top = 15.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))

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
                    Icons.Rounded.AccountCircle, contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = ButtonColors(MaterialTheme.colorScheme.onSurfaceVariant,
                MaterialTheme.colorScheme.onPrimary,
                MaterialTheme.colorScheme.inverseOnSurface ,
                MaterialTheme.colorScheme.inversePrimary),
            onClick = {
                emailError = if (email.isBlank()) "Email is required"
                else if (!Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches()
                ) "Enter a valid email address"
                else ""

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 90.dp)
        ) {
            Text(text = "Send verification message",
                textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Back to login",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                navController.navigate("login")
            })

    }

}

@Preview
@Composable
fun ForgetPasswordPreview(){
    CityAdvertisementTheme {
        val navController = rememberNavController();
        Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->
            ForgetPasswordScreen(navController, paddingValues = innerpadding)
        }
    }
}