package com.example.myevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myevent.ui.MyApp
import com.example.myevent.ui.theme.MyEventTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyEventTheme {
                MyApp(
                    windowSizeClass = calculateWindowSizeClass(activity = this),
//                    accessToken = checkAccessToken(uiState = uiState)
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}
//lambda function
//Android Lifecycle
//Vmodel
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyEventTheme {
        Greeting("Android")
    }
}