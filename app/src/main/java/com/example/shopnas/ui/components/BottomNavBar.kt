package com.example.shopnas.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.shopnas.navigation.ROUT_DASHBOARD
import com.example.shopnas.navigation.ROUT_HOME
import com.example.shopnas.navigation.ROUT_UPLOAD_ORDER
import com.example.shopnas.navigation.ROUT_VIEW_ORDER

@Composable
fun BottomNavigationBar(navController: NavController, selectedIndex: Int) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedIndex == 0,
            onClick = {
                if (selectedIndex != 0) {
                    navController.navigate(ROUT_HOME) {
                        popUpTo(ROUT_HOME) { inclusive = true }
                    }
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Shop") },
            label = { Text("Shop") },
            selected = selectedIndex == 1,
            onClick = {
                if (selectedIndex != 1) {
                    navController.navigate(ROUT_UPLOAD_ORDER)
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.AutoMirrored.Filled.ListAlt, contentDescription = "Orders") },
            label = { Text("Orders") },
            selected = selectedIndex == 2,
            onClick = {
                if (selectedIndex != 2) {
                    navController.navigate(ROUT_VIEW_ORDER)
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = selectedIndex == 3,
            onClick = {
                if (selectedIndex != 3) {
                    navController.navigate(ROUT_DASHBOARD)
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}
