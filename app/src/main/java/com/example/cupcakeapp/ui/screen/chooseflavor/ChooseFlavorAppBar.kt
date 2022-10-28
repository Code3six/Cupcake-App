package com.example.cupcakeapp.ui.screen.chooseflavor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun ChooseFlavorAppBar(
    navController: NavHostController
){
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.appTheme)
            .height(56.dp)
            .fillMaxWidth()
            .padding(12.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Arrow Back Icon",
            tint = MaterialTheme.colors.whiteText,
            modifier = Modifier
                .clickable {
                    navController.navigate(route = "order")
                }
        )
        Text(
            text = "Choose Flavor",
            style = MaterialTheme.typography.appBar,
            color = MaterialTheme.colors.whiteText
        )
    }
}

@Preview
@Composable
fun ChooseFlavorAppBarPreview(){
    CupcakeAppTheme {
    }
}