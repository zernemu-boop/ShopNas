package com.example.shopnas.ui.screens.orders

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shopnas.models.OrderViewModel
import com.example.shopnas.navigation.ROUT_HOME
import com.example.shopnas.ui.components.BottomNavigationBar
import com.example.shopnas.ui.theme.Purple40
import com.example.shopnas.ui.theme.Purple80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderUploadScreen(navController: NavController) {

    // Create ViewModel safely
    val context = LocalContext.current
    val orderViewModel = if (LocalInspectionMode.current) null else remember { OrderViewModel(navController, context) }

    Scaffold(

        //Top Bar
        topBar = {
            TopAppBar(
                title = { Text("Order Now") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Purple40,
                    actionIconContentColor = Purple40
                )
            )
        },

        //Bottom Bar
        bottomBar = {
            BottomNavigationBar(navController = navController, selectedIndex = 1)
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Action */ },
                containerColor = Purple80
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { paddingValues ->

        // Main Screen Content with padding from Scaffold
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            var productName by remember { mutableStateOf("") }
            var quantity by remember { mutableStateOf("") }
            var price by remember { mutableStateOf("") }
            var address by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                OutlinedTextField(
                    value = productName,
                    onValueChange = { productName = it },
                    label = { Text("Product Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantity") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Price") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Delivery Address") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        orderViewModel?.uploadOrder(
                            productName,
                            quantity.toIntOrNull() ?: 1,
                            price.toDoubleOrNull() ?: 0.0,
                            address
                        )
                    },
                    colors = ButtonDefaults.buttonColors(Purple80)
                ) {
                    Text("Upload Order")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderUploadScreenPreview() {
    OrderUploadScreen(rememberNavController())
}