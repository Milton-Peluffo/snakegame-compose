package com.tomildev.snakegame_compose.ui.gameui

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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.snakegame_compose.gamelogic.Direction

@Composable
fun GameButtons(
    onDirectionChange: (Direction) -> Unit
) {

    val directionButtonSize = 42.dp
    val buttonSize = 50.dp
    val cornerRadius = 5.dp

    Row(
        modifier = Modifier
            .padding(vertical = 90.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DirectionalButton(
                size = directionButtonSize, direction = Direction.UP, onDirectionChange,
                shape = RoundedCornerShape(
                    topEnd = cornerRadius,
                    topStart = cornerRadius
                )
            )

            Row(
                modifier = Modifier
            ) {
                DirectionalButton(
                    size = directionButtonSize, direction = Direction.LEFT, onDirectionChange,
                    shape = RoundedCornerShape(
                        topStart = cornerRadius,
                        bottomStart = cornerRadius
                    )
                )

                Button(
                    modifier = Modifier
                        .size(directionButtonSize),
                    onClick = {},
                    shape = RoundedCornerShape(1.dp),
                    colors = ButtonColors(
                        containerColor = Color(0xFF9330f32),
                        contentColor = Color.Black,
                        disabledContainerColor = Color.Black,
                        disabledContentColor = Color.Black
                    )
                ) {}

                DirectionalButton(
                    size = directionButtonSize, direction = Direction.RIGHT, onDirectionChange,
                    shape = RoundedCornerShape(
                        topEnd = cornerRadius,
                        bottomEnd = cornerRadius
                    )
                )
            }
            DirectionalButton(
                size = directionButtonSize, direction = Direction.DOWN, onDirectionChange,
                shape = RoundedCornerShape(
                    bottomStart = cornerRadius,
                    bottomEnd = cornerRadius
                )
            )
        }

        Spacer(modifier = Modifier.padding(horizontal = 70.dp))
        Column(
            modifier = Modifier
                .rotate(40f)
        ) {
            OptionButton(size = buttonSize, text = "A")
            OptionButton(size = buttonSize, text = "B")
        }

    }

}

@Composable
fun DirectionalButton(
    size: Dp,
    direction: Direction,
    onDirectionChange: (Direction) -> Unit,
    shape: RoundedCornerShape
) {

    Button(
        modifier = Modifier
            .size(size),
        onClick = { onDirectionChange(direction) },
        shape = shape as androidx.compose.ui.graphics.Shape,
        colors = ButtonColors(
            containerColor = Color(0xFF9330f32),
            contentColor = Color.Black,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ) {
    }
}

@Composable
fun OptionButton(size: Dp, text: String) {

    Column(
        modifier = Modifier
            .rotate(285f),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {},
            modifier = Modifier.size(size),
            shape = RoundedCornerShape(50),
            colors = ButtonColors(
                containerColor = Color(0xFF97a0234),
                contentColor = Color.Black,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.Black
            )
        ) { }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Text(
            text, modifier = Modifier,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 17.sp
        )
    }
}