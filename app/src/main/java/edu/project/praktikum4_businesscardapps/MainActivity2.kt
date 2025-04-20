package edu.project.praktikum4_businesscardapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.project.praktikum4_businesscardapps.ui.theme.Praktikum4_BusinessCardAppsTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praktikum4_BusinessCardAppsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        BusinessCard()
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val accentColor = Color(0xFFB0C4DE)

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0B0C10),
            Color(0xFF1F2833),
            Color(0xFF2C3E50)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cici),
            contentDescription = "Profile",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "CIKITA MEYDILVIRA",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "CEO Tech Startup",
            fontSize = 16.sp,
            color = accentColor
        )

        Spacer(modifier = Modifier.height(32.dp))
        
        ContactRow(icon = Icons.Default.Phone, info = "+62 12333444555", iconColor = accentColor)
        ContactRow(icon = Icons.Default.Share, info = "@Tech", iconColor = accentColor)
        ContactRow(icon = Icons.Default.Email, info = "cikita.@teckstrat.com", iconColor = accentColor)
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String, iconColor: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = info, color = Color.White)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    Praktikum4_BusinessCardAppsTheme {
        BusinessCard()
    }
}
