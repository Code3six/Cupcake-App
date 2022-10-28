package com.example.cupcakeapp.ui.screen.choosepickupdate

import androidx.compose.foundation.clickable
import com.example.cupcakeapp.ui.components.RadioGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcakeapp.data.DataSource
import com.example.cupcakeapp.data.DataSource.dates
import com.example.cupcakeapp.ui.theme.*
import com.example.cupcakeapp.ui.screen.chooseflavor.ChooseFlavorContent
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun ChoosePickupDateContent(
    cupcakeViewModel: CupcakeViewModel,
    navController: NavHostController
){

    var (selected, setSelected) = remember { mutableStateOf("")}
    val order by cupcakeViewModel.order.collectAsState()


    Column(
        modifier = Modifier
            .padding(24.dp, 24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        RadioGroup(
            items = dates,
            selected = selected,
            setSelected = setSelected
        )

        Divider()

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Text(
                text = "Subtotal:$${order.price}",
                style = MaterialTheme.typography.details
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = {
                    cupcakeViewModel.cancelOrder()
                    navController.popBackStack(
                        route = "order",
                        inclusive = true
                    )
                          },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            ) {

                Text(
                    text = "Cancel",
                    color = MaterialTheme.colors.appTheme
                )
            }
            Button(
                onClick = {
                    cupcakeViewModel.pickDate(selected)
                    navController.navigate(route = "ordersummary")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.appTheme
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Next",
                    color = MaterialTheme.colors.whiteText
                )
            }
        }
    }

}





@Preview(showBackground = true)
@Composable
fun ChoosePickupDateContentPreview(){
    CupcakeAppTheme {
    }
}