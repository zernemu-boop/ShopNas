package com.example.shopnas.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

//everything starts with a capital letters except from style that are in brackets

@Composable
fun LoginScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){

    LoginScreen(rememberNavController())

}


