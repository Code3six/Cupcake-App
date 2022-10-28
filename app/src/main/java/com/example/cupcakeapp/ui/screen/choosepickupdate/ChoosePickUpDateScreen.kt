package com.example.cupcakeapp.ui.screen.choosepickupdate

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.cupcakeapp.ui.theme.CupcakeAppTheme
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun ChoosePickupDateScreen(
    cupcakeViewModel: CupcakeViewModel,
    navController: NavHostController
){
    Scaffold(
        topBar = {
            ChoosePickupDateAppBar()
        },
        content = {
            ChoosePickupDateContent(
                cupcakeViewModel = cupcakeViewModel,
                navController = navController
            )
        }
    )
}

@Preview
@Composable
fun ChoosePickupDateScreenPreview(){
    CupcakeAppTheme {
    }
}