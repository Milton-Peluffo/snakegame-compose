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

    var isAtBoundary by remember { mutableStateOf(false) }
    var foodPosition by remember { mutableStateOf(Position(0, 0)) }

    fun generateRandomPosition(): Position {
        val x = (0 until grid.columns).random()
        val y = (0 until grid.rows).random()
        return Position(x, y)
    }

    LaunchedEffect(Unit) {
        // Initialize food position when the game starts
        foodPosition = generateRandomPosition()
    }

    LaunchedEffect(gameState) {

        if (gameState == GameState.Playing) {
            while (isActive) {
                val currentHead = snakeBody.first()

                val newHead = when (direction) {
                    Direction.UP -> {
                        val newY = currentHead.y - 1
                        if (newY >= 0) Position(currentHead.x, newY) else null
                    }
                    Direction.DOWN -> {
                        val newY = currentHead.y + 1
                        if (newY < grid.rows) Position(currentHead.x, newY) else null
                    }
                    Direction.LEFT -> {
                        val newX = currentHead.x - 1
                        if (newX >= 0) Position(newX, currentHead.y) else null
                    }
                    Direction.RIGHT -> {
                        val newX = currentHead.x + 1
                        if (newX < grid.columns) Position(newX, currentHead.y) else null
                    }
                }

                isAtBoundary = newHead == null

                newHead?.let { head ->
                    val newBody = mutableListOf(head)
                    newBody.addAll(snakeBody)

                    while (newBody.size > bodySize) {
                        newBody.removeLast()
                    }
                    snakeBody = newBody
                }

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
        foodPosition = foodPosition,
        isAtBoundary = isAtBoundary,
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