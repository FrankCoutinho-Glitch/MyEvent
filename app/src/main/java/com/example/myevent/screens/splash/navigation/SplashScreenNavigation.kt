package com.example.myevent.screens.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myevent.screens.splash.SplashScreen


const val splashNavigationRoute = "splashRoute"

fun NavGraphBuilder.splashRoute(
    navigateToHome: () -> Unit
){

    composable(route = splashNavigationRoute){
        SplashScreen(
            navigateToHome = {
                navigateToHome()
            }
        )
    }

}