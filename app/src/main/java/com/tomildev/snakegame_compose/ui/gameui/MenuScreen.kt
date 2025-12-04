package com.tomildev.snakegame_compose.ui.gameui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.snakegame_compose.R

@Composable
fun MenuScreen(onStartClicked: () -> Unit){

    val infiniteTransition = rememberInfiniteTransition(label = "TextBlinkTransition")
    val textAlpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1880),
            repeatMode = RepeatMode.Reverse
        ),
        label = "TextBlinkAlpha"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onStartClicked() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.snake_splash_art),
            contentDescription = "Snake Splash Art",
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "PRESS START TO PLAY",
            fontSize = 11.sp,
            color = Color.Black.copy(alpha = textAlpha),
            fontWeight = FontWeight.Normal
        )

    }

}