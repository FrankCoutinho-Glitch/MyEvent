package com.example.myevent.ui


import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
//import com.example.myevent.presentation.screens.auth.signIn.navigation.navigateToSignIn
//import com.example.myevent.presentation.screens.community.navigation.navigateToCommunity
//import com.example.myevent.presentation.screens.eventCreation.navigation.navigateToCreateEvent
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberMyAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
//    connectivity: NetworkConnectivityObserver,
): MyAppState {
    return remember(
        navController,
        windowSizeClass,
        coroutineScope,
//        connectivity
    ) {
        MyAppState(
            navController,
            windowSizeClass,
            coroutineScope,
//            connectivity
        )
    }
}
class MyAppState(
    val navController: NavHostController,
    private val windowSizeClass: WindowSizeClass,
    private val coroutineScope: CoroutineScope,
//    private val connectivity: NetworkConnectivityObserver,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

//    fun navigateToCreateEvent(){
//        navController.navigateToCreateEvent()
//    }
//    fun navigateToCommunityEvents(){
//        navController.navigateToCommunity()
//    }
//
//    fun navigateToSignIn(){
//        navController.navigateToSignIn()
//    }
}
