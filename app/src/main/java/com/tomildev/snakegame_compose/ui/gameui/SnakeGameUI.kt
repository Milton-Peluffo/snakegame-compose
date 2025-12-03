package com.tomildev.snakegame_compose.ui.gameui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tomildev.snakegame_compose.gamelogic.Direction
import com.tomildev.snakegame_compose.gamelogic.GridConfig
import com.tomildev.snakegame_compose.gamelogic.Position

val cellSize = 20.dp

// "Screen" of the snake game
@Composable
fun GameScreen(
    grid: GridConfig,
    snakeBody: List<Position>,
    onDirectionChange: (Direction) -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val gridWith = cellSize * grid.columns
        val gridHeight = cellSize * grid.rows

        Box(
            modifier = Modifier
                .size(width = gridWith, height = gridHeight)
                .background(Color(0xFF9acc99))
                .border(2.dp, color = Color.Black)
                .clipToBounds()
        ){
            SnakeBody(snakeBody)
        }
        DirectionButtons(onDirectionChange)
    }
}


@Composable
fun SnakeBody(
    bodyBoxes: List<Position>
){
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

// SnakeBox, child of snake screen
//@Composable
//fun snake(
//    position: Position
//){
//    val cellSize = 20.dp
//
//    Box(
//        modifier = Modifier
//            .offset(
//                x = (cellSize * position.x),
//                y = (cellSize * position.y)
//            )
//            .size(cellSize)
//            .background(Color.Black)
//            .border(2.dp, Color.Black)
//
//    ) {
//    }
//}