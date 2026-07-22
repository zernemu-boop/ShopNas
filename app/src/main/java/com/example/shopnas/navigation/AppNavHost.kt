package com.example.shopnas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopnas.ui.screens.auth.LoginScreen
import com.example.shopnas.ui.screens.auth.RegisterScreen
import com.example.shopnas.ui.screens.home.HomeScreen
import com.example.shopnas.ui.screens.onboarding.OnboardingScreen1
import com.example.shopnas.ui.screens.onboarding.OnboardingScreen2
import com.example.shopnas.ui.screens.onboarding.OnboardingScreen3


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_HOME
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUT_ONBOARDING1) {
            OnboardingScreen1(navController)
        }

        composable(ROUT_ONBOARDING2) {
            OnboardingScreen2(navController)
        }

        composable(ROUT_ONBOARDING3) {
            OnboardingScreen3(navController)
        }

    }
}