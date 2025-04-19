package com.nsu.cityadvertisement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.nsu.cityadvertisement.ui.theme.CityAdvertisementTheme
import com.nsu.cityadvertisement.registration.view.AppNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CityAdvertisementTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 AppNavigator(paddingValues = innerPadding)
                }
            }
        }
    }
}

