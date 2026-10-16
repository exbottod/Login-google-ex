package com.testex.app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProfileScreen(user: UserData, onLogout: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!user.pictureUrl.isNullOrEmpty()) {
            AsyncImage(model = user.pictureUrl, contentDescription = "Avatar",
                modifier = Modifier.size(120.dp).clip(CircleShape))
        } else {
            Surface(modifier = Modifier.size(120.dp), shape = CircleShape,
                color = MaterialTheme.colorScheme.primary) {
                Box(contentAlignment = Alignment.Center) {
                    Text(user.name.firstOrNull()?.uppercase() ?: "?",
                        fontSize = 48.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(Modifier.height(20.dp))
        Text(user.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(user.email, fontSize = 14.sp, color = Color.Gray)

        Spacer(Modifier.height(8.dp))
        AssistChip(onClick = {}, label = { Text("Login via ${user.provider}") })

        Spacer(Modifier.height(32.dp))
        Button(
            onClick = onLogout,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) { Text("Logout", fontWeight = FontWeight.Bold) }
    }
}
