package com.tomildev.snakegame_compose.ui.gameui

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tomildev.snakegame_compose.gamelogic.Direction
import com.tomildev.snakegame_compose.gamelogic.GridConfig
import com.tomildev.snakegame_compose.gamelogic.Position

val cellSize = 13.dp

// "Screen" of the snake game
@Composable
fun GameScreen(
    grid: GridConfig,
    snakeBody: List<Position>,
    onDirectionChange: (Direction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val gridWith = cellSize * grid.columns
        val gridHeight = cellSize * grid.rows

        Box(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 23.dp,
                        topEnd = 23.dp,
                        bottomStart = 23.dp,
                        bottomEnd = 70.dp
                    )
                )
                .background(color = Color(0xFF9370f32))
                .size(height = 370.dp, width = 400.dp),

            //contentAlignment = Alignment.CenterStart
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    // Style lines above the screen
                    Box(
                        modifier = Modifier
                            .background(color = Color.Red)
                            .size(height = 8.dp, width = 300.dp),
                    )
                }
                // Main battery and screen row
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    // Battery Column
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 65.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50))
                                .size(width = 15.dp, height = 15.dp)
                                .background(Color.Red)
                        ) {
                        }
                        Text(
                            "Battery", modifier = Modifier
                                .padding(vertical = 4.dp),
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    // Screen Box
                    Box(
                        modifier = Modifier
                            .size(width = gridWith, height = gridHeight)
                            .background(Color(0xFF9acc99))
                            .border(2.dp, color = Color.Black)
                    ) {
                        SnakeBody(snakeBody)
                    }
                }
            }
        }
        GameButtons(onDirectionChange)
    }
}

@Composable
fun SnakeBody(
    bodyBoxes: List<Position>
) {
    bodyBoxes.forEach { position ->
        Box(
            modifier = Modifier
                .offset(
                    x = (cellSize * position.x),
                    y = (cellSize * position.y)
                )
                .size(cellSize)
                .background(Color.Black)
                .border(1.dp, Color(0xFF9acc99))
        )
    }
}