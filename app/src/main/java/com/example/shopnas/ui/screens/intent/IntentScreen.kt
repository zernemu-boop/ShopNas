package com.example.shopnas.ui.screens.intent

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shopnas.ui.theme.ShopNasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController) {
    val mContext = LocalContext.current

    val actions = listOf(
        IntentAction(
            title = "Pay via M-Pesa",
            description = "Quick and secure mobile payment",
            icon = Icons.Default.Payments,
            color = MaterialTheme.colorScheme.primary,
            onClick = {
                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }
            }
        ),
        IntentAction(
            title = "WhatsApp Support",
            description = "Instant chat with our team",
            icon = Icons.AutoMirrored.Filled.Message,
            color = androidx.compose.ui.graphics.Color(0xFF25D366),
            onClick = {
                val url = "https://api.whatsapp.com/send?phone=254741522720"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = url.toUri()
                mContext.startActivity(i)
            }
        ),
        IntentAction(
            title = "Track My Order",
            description = "See live delivery status on Map",
            icon = Icons.Default.LocationOn,
            color = MaterialTheme.colorScheme.tertiary,
            onClick = {
                val mapIntent = Intent(Intent.ACTION_VIEW, "geo:-1.286389,36.817223?z=15".toUri())
                mapIntent.setPackage("com.google.android.apps.maps")
                mContext.startActivity(mapIntent)
            }
        ),
        IntentAction(
            title = "Email Support",
            description = "For detailed inquiries & returns",
            icon = Icons.Default.Email,
            color = MaterialTheme.colorScheme.secondary,
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@shopnas.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Customer Inquiry")
                mContext.startActivity(shareIntent)
            }
        ),
        IntentAction(
            title = "Call Hotline",
            description = "24/7 Toll-free assistance",
            icon = Icons.Default.Phone,
            color = MaterialTheme.colorScheme.primary,
            onClick = {
                val callIntent = Intent(Intent.ACTION_DIAL)
                callIntent.data = "tel:0720245837".toUri()
                mContext.startActivity(callIntent)
            }
        ),
        IntentAction(
            title = "Share ShopNas",
            description = "Invite friends & earn credits",
            icon = Icons.Default.Share,
            color = MaterialTheme.colorScheme.secondary,
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out ShopNas! https://shopnas.com")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
        )
    )

    //Scaffold
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Customer Center") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "How can we help you today?",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                fontWeight = FontWeight.Bold
            )
            
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(actions) { action ->
                    IntentActionCard(action)
                }
            }
        }
    }
}

data class IntentAction(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val color: androidx.compose.ui.graphics.Color,
    val onClick: () -> Unit
)

@Composable
fun IntentActionCard(action: IntentAction) {
    ElevatedCard(
        onClick = action.onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(60.dp),
                shape = CircleShape,
                color = action.color.copy(alpha = 0.12f)
            ) {
                Icon(
                    imageVector = action.icon,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(28.dp),
                    tint = action.color
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .weight(1f)
            ) {
                Text(
                    text = action.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = action.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntentScreenPreview() {
    ShopNasTheme {
        IntentScreen(rememberNavController())
    }
}
