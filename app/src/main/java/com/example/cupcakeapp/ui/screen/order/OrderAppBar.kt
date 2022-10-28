package com.example.cupcakeapp.ui.screen.order

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcakeapp.ui.theme.CupcakeAppTheme
import com.example.cupcakeapp.ui.theme.appBar
import com.example.cupcakeapp.ui.theme.appTheme
import com.example.cupcakeapp.ui.theme.whiteText

@Composable
fun OrderAppBar(){
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.appTheme)
            .height(56.dp)
            .fillMaxWidth()
            .padding(48.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Cupcake",
            style = MaterialTheme.typography.appBar,
            color = MaterialTheme.colors.whiteText
        )
    }
}

@Composable
@Preview
fun OrederAppBarPreview(){
    CupcakeAppTheme {
    }
}