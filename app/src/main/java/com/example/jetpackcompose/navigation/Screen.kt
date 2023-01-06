package com.example.jetpackcompose.navigation

sealed class Screen(val route:String) {
    object Home: Screen(route = "home")
    object ElectionData: Screen(route = "election_data")


}