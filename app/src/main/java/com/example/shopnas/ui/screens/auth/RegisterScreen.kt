package com.example.shopnas.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shopnas.R
import com.example.shopnas.navigation.ROUT_ONBOARDING2
import com.example.shopnas.ui.theme.DarkSurface
import com.example.shopnas.ui.theme.LightSecondary
import com.example.shopnas.ui.theme.Pink40
import com.example.shopnas.ui.theme.Purple40
import com.example.shopnas.ui.theme.Purple80

@Composable
fun RegisterScreen(navController: NavController){

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            //BackgroundImage
            .paint(painter = painterResource(R.drawable.img_4), contentScale = ContentScale.Crop)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.cart),
            contentDescription = "register",
            modifier = Modifier.size(220.dp)
        )

        Text(
            text = "Join us and start your journey today!",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
            color = Purple80,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Username
        OutlinedTextField(
            value = username,
            onValueChange ={ username= it },
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.PersonOutline, contentDescription = "") },
            label = {Text(text = "Username")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = LightSecondary,
                focusedBorderColor = DarkSurface,
                unfocusedLeadingIconColor = LightSecondary,
                focusedLeadingIconColor = DarkSurface
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        //E-mail address
        OutlinedTextField(
            value = email,
            onValueChange ={ email= it },
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            label = {Text(text = "Email Address")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = LightSecondary,
                focusedBorderColor = DarkSurface,
                unfocusedLeadingIconColor = LightSecondary,
                focusedLeadingIconColor = DarkSurface
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Password
        OutlinedTextField(
            value = password,
            onValueChange ={ password= it },
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Password, contentDescription = "") },
            label = {Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = LightSecondary,
                focusedBorderColor = DarkSurface,
                unfocusedLeadingIconColor = LightSecondary,
                focusedLeadingIconColor = DarkSurface
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Confirm Password
        OutlinedTextField(
            value = confirmpassword,
            onValueChange ={ confirmpassword= it },
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Password, contentDescription = "") },
            label = {Text(text = "Confirm Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = LightSecondary,
                focusedBorderColor = DarkSurface,
                unfocusedLeadingIconColor = LightSecondary,
                focusedLeadingIconColor = DarkSurface
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = LightSecondary),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.width(200.dp).height(56.dp)
        ) {
            Text(text = "Register", style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}
