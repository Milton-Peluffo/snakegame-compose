package com.tomildev.snakegame_compose.ui.gameui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tomildev.snakegame_compose.gamelogic.Direction

@Composable
fun DirectionButtons(
    onDirectionChange: (Direction) -> Unit
) {

    val buttonSize = 45.dp
    val cornerRadius = 5.dp

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DirectionalButton(
            size = buttonSize, direction = Direction.UP, onDirectionChange,
            shape = RoundedCornerShape(
                topEnd = cornerRadius,
                topStart = cornerRadius
            )
        )

        Row(
            modifier = Modifier
        ) {
                DirectionalButton(
                    size = buttonSize, direction = Direction.LEFT, onDirectionChange,
                    shape = RoundedCornerShape(
                        topStart = cornerRadius,
                        bottomStart = cornerRadius
                    )
                )

            Button(
                modifier = Modifier
                    .size(buttonSize),
                onClick = {},
                shape = RoundedCornerShape(1.dp),
                colors = ButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.Black
                )
            ) {}

            DirectionalButton(
                size = buttonSize, direction = Direction.RIGHT, onDirectionChange,
                shape = RoundedCornerShape(
                    topEnd = cornerRadius,
                    bottomEnd = cornerRadius
                )
            )
        }
        DirectionalButton(
            size = buttonSize, direction = Direction.DOWN, onDirectionChange,
            shape = RoundedCornerShape(
                bottomStart = cornerRadius,
                bottomEnd = cornerRadius
            )
        )
    }
}

@Composable
fun DirectionalButton(size: Dp, direction: Direction, onDirectionChange: (Direction) -> Unit, shape: RoundedCornerShape) {

    Button(
        modifier = Modifier
            .size(size),
        onClick = { onDirectionChange(direction) },
        shape = shape as androidx.compose.ui.graphics.Shape,
        colors = ButtonColors(
            containerColor = Color.Black,
            contentColor = Color.Black,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ) {
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