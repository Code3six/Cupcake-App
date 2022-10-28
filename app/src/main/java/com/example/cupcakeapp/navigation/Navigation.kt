package com.example.cupcakeapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cupcakeapp.ui.screen.chooseflavor.ChooseFlavorScreen
import com.example.cupcakeapp.ui.screen.choosepickupdate.ChoosePickupDateScreen
import com.example.cupcakeapp.ui.screen.order.OrderScreen
import com.example.cupcakeapp.ui.screen.ordersummary.OrderSummaryScreen
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    cupcakeViewModel: CupcakeViewModel = viewModel()
){
    NavHost(navController = navController, startDestination = "order"){
        composable(route = "order"){
            OrderScreen(
                navController = navController,
                cupcakeViewModel = cupcakeViewModel
            )
        }
        composable(route = "chooseflavor"){
            ChooseFlavorScreen(
                navController = navController,
                cupcakeViewModel = cupcakeViewModel
            )
        }
        composable(route = "choosepickupdate"){
            ChoosePickupDateScreen(
                navController = navController,
                cupcakeViewModel = cupcakeViewModel
            )
        }
        composable(route = "ordersummary"){
            OrderSummaryScreen(
                navController = navController,
                cupcakeViewModel = cupcakeViewModel
            )
        }
    }
}