package com.example.jetpackcompose.ui.screens.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.jetpackcompose.navigation.Screen

@Composable
fun MainScreen( navController: NavHostController){


    Column() {

        Text(text = "Rocky")

        Button(onClick = {
            navController.navigate(route = Screen.ElectionData.route)
        }) {
            Text(text = "Go to next Screen")

        }

    }

}