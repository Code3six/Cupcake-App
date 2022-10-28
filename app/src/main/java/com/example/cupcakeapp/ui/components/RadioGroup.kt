package com.example.cupcakeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.cupcakeapp.ui.theme.Purple500
import com.example.cupcakeapp.ui.theme.details

@Composable
fun RadioGroup(
    items: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit
){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.details
                    )
                    RadioButton(
                        selected = selected == item,
                        onClick = {
                            setSelected(item)
                        },
                        enabled = true,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Purple500
                        )
                    )

                }
            }
        }
    }
}