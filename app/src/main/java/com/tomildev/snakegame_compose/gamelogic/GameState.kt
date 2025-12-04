package com.tomildev.snakegame_compose.gamelogic


sealed class  GameState {
    object Menu : GameState()
    object Playing : GameState()
}

data class Position(
    val x: Int,
    val y: Int
)

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

data class GridConfig(
    val columns: Int = 18,
    val rows: Int = 20
)