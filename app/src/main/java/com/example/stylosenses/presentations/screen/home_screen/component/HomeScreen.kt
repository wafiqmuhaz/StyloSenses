package com.example.stylosenses.presentations.screen.home_screen.component

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import androidx.navigation.compose.rememberScaffoldState
import com.example.stylosenses.presentations.graph.detail.DetailScreen
import com.example.stylosenses.presentations.graph.home.HomeNavGraph


@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
//    scaffoldState: ScaffoldState = rememberScaffoldState(),
    boxScrollState: ScrollState = rememberScrollState(),
) {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    //topBar visibility state
    val topBarVisibilityState = remember {
        mutableStateOf(true)
    }


    Scaffold(
//        scaffoldState = scaffoldState,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            AppBar(
                navController = navController,
                isVisible = topBarVisibilityState.value,
                searchCharSequence = {

                },
                onCartIconClick = {
                    navController.navigate(DetailScreen.CartScreen.route)
                },
                onNotificationIconClick = {
                    navController.navigate(DetailScreen.NotificationScreen.route)
                })
        },
        bottomBar = {
            NavigationBarWidgets(navController = navController) { isVisible ->
                topBarVisibilityState.value = isVisible
            }
        }

    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(boxScrollState)
        ) {
            HomeNavGraph(navHostController = navController)
        }
    }
}