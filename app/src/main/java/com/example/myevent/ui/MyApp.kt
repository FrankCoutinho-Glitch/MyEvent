package com.example.myevent.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myevent.navigation.EventNavHost
import com.example.myevent.presentation.components.NavigationDrawer
//import com.example.myevent.presentation.screens.community.navigation.communityRoute
import com.example.myevent.ui.theme.MyEventTheme
import com.example.myevent.utils.MyButtonsColors
import kotlinx.coroutines.launch

@Composable
fun MyApp(
//    accessToken: String,
    windowSizeClass: WindowSizeClass,
//    connectivity: NetworkConnectivityObserver,
){
    MyContent(
//        accessToken = accessToken,
        windowSizeClass = windowSizeClass
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyContent(
//    accessToken: String,
    windowSizeClass: WindowSizeClass,
    appState: MyAppState = rememberMyAppState(
        windowSizeClass = windowSizeClass,
//        connectivity = connectivity,
    ),
){
    //User Drawer here and scaffold!
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavigationDrawer(
        drawerState = drawerState,
        onCommunityClicked = {
//            if (accessToken.isNotEmpty()){
//                appState.navigateToCommunityEvents()
//
//            }else{
//                appState.navigateToSignIn()
//            }

            scope.launch {
                drawerState.close()
            }
        }) {
        Scaffold(
            modifier = Modifier,
            floatingActionButton = {
                //Show for signed users
                if (appState.currentDestination?.route == "communityRoute"){
                    FloatingActionButton(
                        modifier = Modifier
                            .padding(4.dp),
                        containerColor = MyButtonsColors.buttonColor,
                        onClick = {}
                    ) {
                        Box(
                            modifier = Modifier
                        ) {
                            Icon(
                                modifier = Modifier,
                                imageVector = Icons.Default.Add,
                                tint = MyButtonsColors.white,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        ) {
            EventNavHost(
                appState= appState,
                paddingValues = it,
                onMenuClicked = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )
        }
    }
}
