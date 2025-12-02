package com.tomildev.`snakegame-compose`.gameLogic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun SnakeGameScreen() {

    val grid = rememberSaveable { GridConfig(columns = 10, rows = 15) }

    //Posicion Inicial de cuadrito
    var position by remember { mutableStateOf(Position(5, 5)) }

    //Direccion Inicial del cuadrito
    var direction by remember { mutableStateOf(Direction.RIGHT)}

    //

}