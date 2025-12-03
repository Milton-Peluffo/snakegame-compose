package com.tomildev.snakegame_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tomildev.snakegame_compose.gameLogic.Direction
import com.tomildev.snakegame_compose.gameLogic.GridConfig
import com.tomildev.snakegame_compose.gameLogic.Position

val cellSize = 20.dp

// "Screen" of the snake game
@Composable
fun GameScreen(
    grid: GridConfig,
    position: Position,
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
                .background(Color.LightGray)
                .border(2.dp, color = Color.Black)
                .clipToBounds()
        ){
            snake(position)
        }
        DirectionButtons(onDirectionChange)
    }
}

// SnakeBox, child of snake screen
@Composable
fun snake(
    position: Position
){
    val cellSize = 20.dp

    Box(
        modifier = Modifier
            .offset(
                x = (cellSize * position.x),
                y = (cellSize * position.y)
            )
            .size(cellSize)
            .background(Color.Green)
            .border(2.dp, Color.Black)

    ) {
    }
}

//Buttons and their directions
@Composable
fun DirectionButtons(
    onDirectionChange: (Direction) -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(113.dp)
    ) {
        Button(onClick = { onDirectionChange(Direction.UP) }) {
            Text("UP")
        }

        Row {
            Button(onClick = { onDirectionChange(Direction.LEFT) }) {
                Text("LEFT")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = { onDirectionChange(Direction.RIGHT) }) {
                Text("RIGHT")
            }
        }

        Button(onClick = { onDirectionChange(Direction.DOWN) }) {
            Text("DOWN")
        }
    }
}