package com.example.myevent.screens.home


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myevent.model.Community
import com.example.myevent.model.Event
import com.example.myevent.model.Result

@Composable
fun HomeScreen(
    onMenuClicked: () -> Unit = {},
    navigateToEventDetails: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
){



    val communities by homeViewModel.data.collectAsStateWithLifecycle()
    val events by homeViewModel.events.collectAsStateWithLifecycle()

    when(communities){
        is Result.Success -> {
            HomeContent(
                communities = (communities as Result.Success<List<Community>>).data,
                events = (events as Result.Success<List<Event>>).data
                ,
                onMenuClicked = onMenuClicked,
                searchValue = "",
                onSearchValueChange = {},
                navigateToEventDetails = navigateToEventDetails
            )
        }
        is Result.Error -> {

        }

        else -> {

        }
    }


}


