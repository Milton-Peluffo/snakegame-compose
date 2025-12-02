package com.tomildev.`snakegame-compose`.gameLogic

data class Position(
    val x: Int,
    val y: Int
)

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

data class GridConfig(
    val columns: Int = 10,
    val rows: Int = 15
)