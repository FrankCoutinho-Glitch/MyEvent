package com.example.myevent.screens.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.myevent.screens.home.HomeScreen


const val homeRoute = "home_route"

fun NavController.navigateToHome(){
    navigate(homeRoute){
        popUpTo(homeRoute){
            inclusive = true
        }
    }
}

fun NavGraphBuilder.homeRoute(
    onMenuClicked: () -> Unit = {},
    navigateToEventDetails: () -> Unit,
){
    composable(homeRoute){
        HomeScreen(
            onMenuClicked = onMenuClicked,
            navigateToEventDetails = navigateToEventDetails

        )
    }
}