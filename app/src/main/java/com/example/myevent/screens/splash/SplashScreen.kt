package com.example.myevent.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myevent.presentation.components.SplashIcon
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToHome: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SplashIcon()
    }

    LaunchedEffect(key1 = Unit){
        delay(5000L)
        navigateToHome()
    }


}