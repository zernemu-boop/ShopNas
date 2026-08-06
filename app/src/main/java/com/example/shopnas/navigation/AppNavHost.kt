package com.example.shopnas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shopnas.ui.screens.auth.LoginScreen
import com.example.shopnas.ui.screens.auth.RegisterScreen
import com.example.shopnas.ui.screens.dashboard.DashboardScreen
import com.example.shopnas.ui.screens.home.HomeScreen
import com.example.shopnas.ui.screens.intent.IntentScreen
import com.example.shopnas.ui.screens.onboarding.OnboardingScreen1
import com.example.shopnas.ui.screens.onboarding.OnboardingScreen2
import com.example.shopnas.ui.screens.onboarding.OnboardingScreen3
import com.example.shopnas.ui.screens.orders.OrderUploadScreen
import com.example.shopnas.ui.screens.orders.ViewOrdersScreen
import com.example.shopnas.ui.screens.products.AddProductScreen
import com.example.shopnas.ui.screens.products.UpdateProductScreen
import com.example.shopnas.ui.screens.products.ViewProductScreen
import com.example.shopnas.ui.screens.scaffold.ScaffoldScreen
import com.example.shopnas.ui.screens.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
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

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }

        composable(ROUT_SCAFFOLD) {
            ScaffoldScreen(navController)
        }

        composable(ROUT_VIEW_ORDER) {
            ViewOrdersScreen(navController)
        }

        composable(ROUT_UPLOAD_ORDER) {
            OrderUploadScreen(navController)
        }

        composable(ROUTE_ADD_PRODUCT) { AddProductScreen(navController) }

        composable(ROUTE_VIEW_PRODUCTS) { ViewProductScreen(navController) }

        composable(
            ROUTE_UPDATE_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")!!
            UpdateProductScreen(navController, productId)
        }

    }
}