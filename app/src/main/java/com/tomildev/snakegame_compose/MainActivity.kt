package com.tomildev.snakegame_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tomildev.snakegame_compose.gamelogic.SnakeGame
import com.tomildev.snakegame_compose.ui.theme.SnakegamecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnakegamecomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SnakeGame()
                }
            }
        }
    }
}