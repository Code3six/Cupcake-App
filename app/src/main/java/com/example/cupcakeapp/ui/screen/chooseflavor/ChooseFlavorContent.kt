package com.example.cupcakeapp.ui.screen.chooseflavor

import android.util.Log
import androidx.compose.foundation.clickable
import com.example.cupcakeapp.ui.components.RadioGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcakeapp.data.DataSource
import com.example.cupcakeapp.ui.theme.*
import com.example.cupcakeapp.viewmodel.CupcakeViewModel

@Composable
fun ChooseFlavorContent(
    navController: NavHostController,
    cupcakeViewModel: CupcakeViewModel
){

    val order by cupcakeViewModel.order.collectAsState()

    var (selected, setSelected) = remember { mutableStateOf("")}
    var flavors = DataSource.flavors.map {
        it.name
    }
    var price = DataSource.flavors.map {
        it.price
    }


    Column(
        modifier = Modifier
            .padding(24.dp, 24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        RadioGroup(
            items = flavors,
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
                text =  "Subtotal: $${getPrice(name = selected, no = order.order)}",
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
                    navController.popBackStack(
                        route = "order",
                        inclusive = false
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
                    cupcakeViewModel.pickFlavor(selected)
                    Log.d("order",cupcakeViewModel.order.value.toString())
                    navController.navigate(route = "choosepickupdate")
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

fun getPrice(name: String, no: Int):Int{
    for(i in DataSource.flavors){
        if(name == i.name){
            return i.price * no
        }
    }
    return 0
}

@Preview(showBackground = true)
@Composable
fun ChooseFlavorContentPreview(){
    CupcakeAppTheme {
    }
}