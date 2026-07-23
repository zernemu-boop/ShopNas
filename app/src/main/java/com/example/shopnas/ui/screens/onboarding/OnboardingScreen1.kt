package com.example.shopnas.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shopnas.R
import com.example.shopnas.navigation.ROUT_ONBOARDING2


@Composable
fun OnboardingScreen1(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //Contents of column fall here, always put commas when styling

        Image(
           painter = painterResource(R.drawable.cart),
            contentDescription = "cart",
            modifier = Modifier.size(100.dp)

        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "ShopNova!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta,
        )

        Text(
            text = "Shop Smart. Live Better",
            fontSize = 20.sp,
        )

        Text(
            text = "Improves customer retention and drives higher conversion rates.#1 Online Store in Kenya ✓ Buy Phones, Laptops, Appliances, Clothes, TVs & Home Essentials from Top Brands ✓ Best Prices in Kenya",
            textAlign = TextAlign.Center
        )

        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2) },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp)
        ) {
            Text(
                text = "Get Started!!"
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen1Preview(){

    OnboardingScreen1(rememberNavController())

}