package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.screens.electionscreen.ElectionData
import com.example.jetpackcompose.ui.screens.mainscreen.MainScreen

@Composable
fun Navigatioin(
    navHostController: NavHostController
){
    NavHost(
        startDestination = Screen.Home.route,
        navController =  navHostController
    ){


        composable(Screen.Home.route){
            MainScreen(navHostController)
        }
        composable(Screen.ElectionData.route){
            ElectionData(navHostController)
        }

    }


}