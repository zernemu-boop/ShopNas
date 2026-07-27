package com.example.shopnas.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shopnas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        ///Start of TopAppBar

        TopAppBar(
            title = { Text(text = "Customer Dashboard") },
            navigationIcon = {

                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart"
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications"
                    )
                }

            },

            colors = TopAppBarDefaults.topAppBarColors(

                containerColor = Color.Cyan,
                navigationIconContentColor = Color.Blue,
                titleContentColor = Color.Black

            )


        )
        ///End of TopAppBar

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Welcome to our Shop",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp)
        )

        //Row

        Row() {

            Column() {
                Image(
                    painter = painterResource(R.drawable.c),
                    contentDescription = "cart",
                    modifier = Modifier.size(100.dp)

                )


            }

        }

        //End of  Row

    }

}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview(){

    DashboardScreen(rememberNavController())

}