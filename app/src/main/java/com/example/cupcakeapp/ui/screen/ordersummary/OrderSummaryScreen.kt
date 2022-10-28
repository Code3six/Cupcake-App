package com.example.cupcakeapp.ui.screen.ordersummary

import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.cupcakeapp.ui.theme.CupcakeAppTheme
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun OrderSummaryScreen(
    navController: NavHostController,
    cupcakeViewModel: CupcakeViewModel,
    context: Context = LocalContext.current
){

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            OrderSummaryAppBar(
                navController = navController
            )
        },
        content = {
            OrderSummaryContent(
                navController = navController,
                cupcakeViewModel = cupcakeViewModel,
                scaffoldState = scaffoldState,
                context = context
            )
        }
    )
}

@Preview
@Composable
fun OrderSummaryScreenPreview(){
    CupcakeAppTheme {
    }
}