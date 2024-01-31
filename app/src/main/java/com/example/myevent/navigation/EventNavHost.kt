package com.example.myevent.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myevent.screens.home.navigation.homeRoute
import com.example.myevent.screens.home.navigation.navigateToHome
import com.example.myevent.screens.splash.navigation.splashNavigationRoute
import com.example.myevent.screens.splash.navigation.splashRoute
import com.example.myevent.ui.MyAppState

@Composable
fun EventNavHost(
    appState: MyAppState,
    startDestination: String = splashNavigationRoute,
    paddingValues: PaddingValues,
    onMenuClicked: () -> Unit
){

    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = splashNavigationRoute){

        homeRoute(
            onMenuClicked = {},
            navigateToEventDetails = {}
        )

        splashRoute(
            navigateToHome = {
                controller.navigateToHome()
            }
        )




    }

}