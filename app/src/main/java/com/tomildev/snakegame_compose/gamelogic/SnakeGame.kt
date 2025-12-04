package com.tomildev.snakegame_compose.gamelogic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tomildev.snakegame_compose.ui.gameui.GameScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun SnakeGame() {

    val grid = remember { GridConfig(columns = 18, rows = 18) }

    var gameState by remember { mutableStateOf<GameState>(GameState.Menu) }
    var snakeBody by remember { mutableStateOf(listOf(Position(5, 5))) }
    var direction by remember { mutableStateOf(Direction.RIGHT) }
    var bodySize by remember { mutableStateOf(5) }

    LaunchedEffect(gameState) {

        if (gameState == GameState.Playing) {
            while (isActive) {
                val currentHead = snakeBody.first()

                val newHead = when (direction) {
                    Direction.UP -> Position(
                        x = currentHead.x,
                        y = (currentHead.y - 1 + grid.rows) % grid.rows
                    )
                    Direction.DOWN -> Position(
                        x = currentHead.x,
                        y = (currentHead.y + 1) % grid.rows
                    )
                    Direction.LEFT -> Position(
                        x = (currentHead.x - 1 + grid.columns) % grid.columns,
                        y = currentHead.y
                    )
                    Direction.RIGHT -> Position(
                        x = (currentHead.x + 1) % grid.columns,
                        y = currentHead.y
                    )
                }

                val newBody = mutableListOf(newHead)
                newBody.addAll(snakeBody)

                while (newBody.size > bodySize) {
                    newBody.removeLast()
                }
                snakeBody = newBody

                delay(200)
            }
        }
    }

    val StartGame = {
        snakeBody = listOf(Position(5, 5))
        direction = Direction.RIGHT
        bodySize = 5
        gameState = GameState.Playing
    }

    GameScreen(
        gameState = gameState,
        onsTartGame = { StartGame() },
        grid = grid,
        snakeBody = snakeBody,
        onDirectionChange = { newDirection ->
            val isOpposite = when(direction) {
                Direction.UP -> newDirection == Direction.DOWN
                Direction.DOWN -> newDirection == Direction.UP
                Direction.LEFT -> newDirection == Direction.RIGHT
                Direction.RIGHT -> newDirection == Direction.LEFT
            }
            if (!isOpposite) {
                direction = newDirection
            }
        }
    )
}