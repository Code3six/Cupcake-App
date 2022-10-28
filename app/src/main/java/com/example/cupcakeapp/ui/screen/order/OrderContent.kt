package com.example.cupcakeapp.ui.screen.order

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcakeapp.R
import com.example.cupcakeapp.data.model.Order
import com.example.cupcakeapp.ui.theme.*
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun OrderContent(
    cupcakeViewModel: CupcakeViewModel,
    navController: NavHostController
){
    Column(
        modifier = Modifier
            .padding(72.dp, 48.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = "cupcake"
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Order Cupcakes",
            style = MaterialTheme.typography.appTitle,
            color = MaterialTheme.colors.blackText
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                cupcakeViewModel.numberOfCupcakes(1)
                navController.navigate(route = "chooseflavor")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.appTheme),
        ){
            Text(
                text = "One Cupcake",
                color = MaterialTheme.colors.whiteText
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                cupcakeViewModel.numberOfCupcakes(6)
                navController.navigate(route = "chooseflavor")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.appTheme),
        ){
            Text(
                text = "Six Cupcake",
                color = MaterialTheme.colors.whiteText
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                cupcakeViewModel.numberOfCupcakes(12)
                navController.navigate(route = "chooseflavor")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.appTheme),
        ){
            Text(
                text = "Twelve Cupcake",
                color = MaterialTheme.colors.whiteText
            )
        }
    }
}



@Preview
@Composable
fun OrderContentPreview(){
    CupcakeAppTheme {
    }
}