package com.example.cupcakeapp.ui.screen.ordersummary

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcakeapp.ui.theme.*
import com.example.cupcakeapp.viewmodel.CupcakeViewModel
import kotlinx.coroutines.launch

@Composable
fun OrderSummaryContent(
    navController: NavHostController,
    cupcakeViewModel: CupcakeViewModel,
    scaffoldState: ScaffoldState,
    context: Context
){
    val order by cupcakeViewModel.order.collectAsState()
    val orderSummary = "${order.order} cupcakes\n" +
                    "${order.flavor} flavor\n" +
                    "${order.price} total\n" +
                    "${order.date} date\n"


    Column(
        modifier = Modifier
            .padding(24.dp, 24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "QUANTITY",
            style = MaterialTheme.typography.details
        )
        Text(
            text = "${order.order}",
            style = MaterialTheme.typography.details2
        )
        Divider()
        Text(
            text = "FLAVOR",
            style = MaterialTheme.typography.details
        )
        Text(
            text = order.flavor,
            style = MaterialTheme.typography.details2
        )
        Divider()
        Text(
            text = "PICKUP DATE",
            style = MaterialTheme.typography.details
        )
        Text(
            text = order.date,
            style = MaterialTheme.typography.details2
        )

        Divider()

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Text(
                text = "Subtotal: $${order.price}",
                style = MaterialTheme.typography.details
            )
        }


            Button(
                onClick = {
                          cupcakeViewModel.shareOrder(
                              context = context,
                              orderSummary = orderSummary
                          )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.appTheme
                )
            ) {

                Text(
                    text = "Send Order to Another App",
                    color = MaterialTheme.colors.whiteText
                )
            }
            OutlinedButton(
                onClick = {
                    navController.popBackStack(
                        route = "order",
                        inclusive = false
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Cancel",
                    color = MaterialTheme.colors.appTheme
                )
            }
        }

}

@Composable
@Preview(showBackground = true)
fun OrderSummaryContentPreview(){
    CupcakeAppTheme {
    }
}