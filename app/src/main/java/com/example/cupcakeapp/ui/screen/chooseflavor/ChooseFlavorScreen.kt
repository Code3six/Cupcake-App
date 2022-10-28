package com.example.cupcakeapp.ui.screen.chooseflavor

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.cupcakeapp.ui.theme.CupcakeAppTheme
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun ChooseFlavorScreen(
    navController: NavHostController,
    cupcakeViewModel: CupcakeViewModel
){
    Scaffold(
        topBar = {
            ChooseFlavorAppBar(
                navController = navController
            )
        },
        content = {
            ChooseFlavorContent(
                navController = navController,
                cupcakeViewModel = cupcakeViewModel
            )
        }
    )
}

@Preview
@Composable
fun ChooseFlavorScreenPreview(){
    CupcakeAppTheme {
    }
}