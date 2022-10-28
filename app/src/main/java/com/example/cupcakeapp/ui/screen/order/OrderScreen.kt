package com.example.cupcakeapp.ui.screen.order

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cupcakeapp.ui.theme.CupcakeAppTheme
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun OrderScreen(
    cupcakeViewModel: CupcakeViewModel,
    navController: NavHostController
){
    Scaffold(
        topBar = {
            OrderAppBar()
        },
        content = {
            OrderContent(
                cupcakeViewModel = cupcakeViewModel,
                navController = navController
            )
        }
    )
}

@Preview
@Composable
fun OrderScreenPreview(){
}