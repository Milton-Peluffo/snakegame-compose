package com.tomildev.snakegame_compose.ui.gameui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import com.tomildev.snakegame_compose.gamelogic.Direction
import com.tomildev.snakegame_compose.gamelogic.GameState
import com.tomildev.snakegame_compose.gamelogic.GridConfig
import com.tomildev.snakegame_compose.gamelogic.Position
import com.tomildev.snakegame_compose.ui.theme.GameBoyBatteryRed
import com.tomildev.snakegame_compose.ui.theme.GameBoyGreenScreen
import com.tomildev.snakegame_compose.ui.theme.GameBoyLightPurple
import com.tomildev.snakegame_compose.ui.theme.GameBoyPurple
import com.tomildev.snakegame_compose.ui.theme.GameBoyRed
import com.tomildev.snakegame_compose.ui.assets.Headphones
import com.tomildev.snakegame_compose.ui.theme.GameBoyDarkWhite
import com.tomildev.snakegame_compose.ui.theme.GameBoyWhite


val cellSize = 13.dp

// "Screen" of the snake game
@Composable
fun GameScreen(
    gameState: GameState,
    onsTartGame: () -> Unit,

    grid: GridConfig,
    snakeBody: List<Position>,
    onDirectionChange: (Direction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val gridWith = cellSize * grid.columns
        val gridHeight = cellSize * grid.rows

        Box(
            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1f)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 23.dp,
                        topEnd = 23.dp,
                        bottomStart = 23.dp,
                        bottomEnd = 70.dp
                    )
                )
                .background(color = GameBoyPurple)
                .size(height = 330.dp, width = 400.dp),

            //contentAlignment = Alignment.CenterStart
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 13.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    // Style lines above the screen
                    Column {
                        Box(
                            modifier = Modifier
                                .background(color = GameBoyRed)
                                .size(height = 4.dp, width = 100.dp),
                        )
                        Spacer(modifier = Modifier.padding(vertical = 4.dp))
                        Box(
                            modifier = Modifier
                                .background(color = GameBoyLightPurple)
                                .size(height = 4.dp, width = 100.dp),
                        )
                    }
                    Text(
                        "DO MATRIX WITH STEREO SOUND", modifier = Modifier
                            .padding(horizontal = 10.dp),
                        color = Color.White,
                        fontSize = 11.sp
                    )
                    Column {
                        Box(
                            modifier = Modifier
                                .background(color = GameBoyRed)
                                .size(height = 4.dp, width = 60.dp),
                        )
                        Spacer(modifier = Modifier.padding(vertical = 4.dp))
                        Box(
                            modifier = Modifier
                                .background(color = GameBoyLightPurple)
                                .size(height = 4.dp, width = 60.dp),
                        )
                    }
                }
                // Main battery and screen row
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    // Battery Column
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 11.dp, vertical = 65.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50))
                                .size(width = 15.dp, height = 15.dp)
                                .background(color = GameBoyBatteryRed)
                        ) {
                        }
                        Text(
                            "BATTERY", modifier = Modifier
                                .padding(vertical = 4.dp),
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    }
                    // Screen Box
                    Box(
                        modifier = Modifier
                            .size(width = gridWith, height = gridHeight)
                            .background(color = GameBoyGreenScreen)
                            .border(2.dp, color = Color(0xFF748F74))
                    ) {
                        // Switch screen state logic
                        when (gameState) {
                            GameState.Menu -> {
                                MenuScreen(onsTartGame)
                            }

                            GameState.Playing -> {
                                SnakeBody(snakeBody)
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Box(
            modifier = Modifier
                .width(400.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF9370f32)
                        )
                    ) {
                        append("Developed by ")
                    }

                    withStyle(
                        style = SpanStyle(
                            fontSize = 27.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xFF9370f32)
                        )
                    ) {
                        append("TOMILDEV")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            color = Color(0xFF9370f32)
                        )
                    ) {
                        append(" TM")
                    }
                }
            )
        }
        GameButtons(
            onDirectionChange = onDirectionChange,
            onStartClick = { if (gameState == GameState.Menu) onsTartGame() }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                //.background(color = Color.Blue)
            ,
        ) {
            ConsolePhones(
                modifier = Modifier
                    .offset(x = 45.dp, y = 70.dp),
            )

            ConsoleSpeaker(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(x = (-15).dp, y = 17.dp),
            )
        }
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

@Composable
fun ConsoleSpeaker(modifier: Modifier) {
    Row(
        modifier = modifier
            .rotate(330f),
        horizontalArrangement = Arrangement.End
    ) {
        repeat(5) {
            Spacer(modifier = Modifier.padding(horizontal = 8.dp, vertical = 20.dp))
            Box(
                modifier = Modifier
                    .size(width = 8.dp, height = 90.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .background(color = GameBoyPurple)
            )
        }
    }
}


@Composable
fun ConsolePhones(modifier: Modifier) {

    Column(modifier = modifier) {
        Box(
            modifier = modifier
                .clip(shape = RoundedCornerShape(50))
                .size(height = 25.dp, width = 90.dp)
                .background(color = GameBoyDarkWhite)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Icon(
                    imageVector = Headphones, contentDescription = "Headphones",
                    modifier = Modifier
                        .size(20.dp),
                    tint = GameBoyWhite
                )
                Spacer(modifier = Modifier.padding(horizontal = 1.dp))
                Text(
                    text = "PHONES",
                    fontSize = 15.sp,
                    color = GameBoyWhite,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
        Row(
            modifier = modifier,
        ) {
            repeat(3){
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                Box(
                    modifier = Modifier
                        .offset(x = 35.dp, y = (-4).dp)
                        .size(height = 100.dp, width = 8.dp)
                        .background(color = GameBoyDarkWhite)
                )
            }
        }

    }
}