package com.testex.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val session = SessionManager(this)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    var user by remember { mutableStateOf(session.getUser()) }
                    if (user == null) {
                        LoginScreen(onLoginSuccess = { loggedIn ->
                            session.saveUser(loggedIn)
                            user = loggedIn
                        })
                    } else {
                        ProfileScreen(user = user!!, onLogout = {
                            session.clear()
                            user = null
                        })
                    }
                }
            }
        }
    }
}
