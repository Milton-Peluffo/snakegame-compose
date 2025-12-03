package com.tomildev.snakegame_compose.ui.gameui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.tomildev.snakegame_compose.gamelogic.Direction

@Composable
fun DirectionButtons(
    onDirectionChange: (Direction) -> Unit

){

    Column (modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        DirectionalButton(direction = Direction.UP, onDirectionChange)

        Row(modifier = Modifier
        ) {
            DirectionalButton(direction = Direction.LEFT, onDirectionChange)
            DirectionalButton(direction = Direction.RIGHT, onDirectionChange)
            DirectionalButton(direction = Direction.RIGHT, onDirectionChange)
        }
        DirectionalButton(direction = Direction.DOWN, onDirectionChange)
    }

}


@Composable
fun DirectionalButton(direction: Direction, onDirectionChange: (Direction) -> Unit){

    Button(
        modifier = Modifier
            .size(50.dp)
        ,
        onClick = { onDirectionChange(direction)},
        shape = RoundedCornerShape(1.dp),
        colors = ButtonColors(
            containerColor = Color.Black,
            contentColor = Color.Black,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
    }

}


////Buttons and their directions
//@Composable
//fun DirectionButtons(
//    onDirectionChange: (Direction) -> Unit
//){
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.padding(113.dp)
//    ) {
//        Button(onClick = { onDirectionChange(Direction.UP) }) {
//            Text("UP")
//        }
//
//        Row {
//            Button(onClick = { onDirectionChange(Direction.LEFT) }) {
//                Text("LEFT")
//            }
//            Spacer(modifier = Modifier.size(16.dp))
//            Button(onClick = { onDirectionChange(Direction.RIGHT) }) {
//                Text("RIGHT")
//            }
//        }
//
//        Button(onClick = { onDirectionChange(Direction.DOWN) }) {
//            Text("DOWN")
//        }
//    }
//}