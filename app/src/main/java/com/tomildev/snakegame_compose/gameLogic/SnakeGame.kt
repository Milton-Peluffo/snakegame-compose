package com.tomildev.`snakegame-compose`.gameLogic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tomildev.snakegame_compose.gameLogic.Direction
import com.tomildev.snakegame_compose.gameLogic.GridConfig
import com.tomildev.snakegame_compose.gameLogic.Position
import com.tomildev.snakegame_compose.ui.GameScreen
import kotlinx.coroutines.delay

@Composable
fun SnakeGame(modifier: Modifier = Modifier) {

    val grid = remember { GridConfig(columns = 18, rows = 18) }
    var position by remember { mutableStateOf(Position(5, 5)) }

    var direction by remember { mutableStateOf(Direction.RIGHT)}

    LaunchedEffect(direction) {
        while (true) {
            delay(200)

            position = when (direction) {
                Direction.UP -> Position(
                    x = position.x,
                    y = (position.y - 1 + grid.columns) % grid.columns
                )
                    Direction.DOWN -> Position(
                        x = position.x,
                        y = (position.y + 1 + grid.columns) % grid.columns
                    )
                    Direction.RIGHT -> Position(
                        x = (position.x + 1 + grid.rows) % grid.rows,
                        y = position.y
                    )
                    Direction.LEFT -> Position(
                        x = (position.x - 1 + grid.rows) % grid.rows,
                        y = position.y
                    )
            }
        }
    }
    GameScreen(
        grid = grid,
        position = position,
        onDirectionChange = { direction = it }
    )
}