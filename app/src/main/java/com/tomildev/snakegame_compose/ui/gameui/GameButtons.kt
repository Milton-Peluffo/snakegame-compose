package com.tomildev.snakegame_compose.ui.gameui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tomildev.snakegame_compose.gamelogic.Direction


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