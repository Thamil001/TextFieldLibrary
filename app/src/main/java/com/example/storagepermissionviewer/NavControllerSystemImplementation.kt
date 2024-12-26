package com.example.storagepermissionviewer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//This NavController start destination start the application to next to go another screen control the System
@Preview
@Composable
fun NavigationSystem() {
    val controller = rememberNavController()

    NavHost(
        navController = controller,
        startDestination = "home"
    ) {
        composable("home") { Home(controller) }
        composable("next") { Next(controller) }
        composable("basicTextField") { BasicTextFieldImplementation(controller) }
    }
}

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable(onClick = { navController.navigate("next") })
    ) {


    }
}

@Composable
fun Next(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .clickable(onClick = { navController.navigate("basicTextField") })
    ) {

    }
}