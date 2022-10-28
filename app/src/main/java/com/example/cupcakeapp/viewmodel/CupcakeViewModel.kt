package com.example.cupcakeapp.viewmodel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.cupcakeapp.R
import com.example.cupcakeapp.data.DataSource
import com.example.cupcakeapp.data.model.Order
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CupcakeViewModel():ViewModel(){

    private val _order = MutableStateFlow(Order())
    val order: StateFlow<Order> = _order.asStateFlow()

    fun numberOfCupcakes(no: Int){
        _order.update {
            it.copy(
                order = no,
                flavor = order.value.flavor,
                date = order.value.date,
                price = priceIt(order.value.flavor, no)
            )
        }
    }

    fun pickFlavor(flavor: String) {
        _order.update {
            it.copy(
                flavor = flavor,
                order = order.value.order,
                date = order.value.date,
                price = priceIt(flavor, order.value.order)
            )
        }
    }

    private fun priceIt(flavor: String, no: Int): Int{
        for(i in DataSource.flavors){
            if(flavor == i.name){
                return i.price * no
            }
        }
        return 0
    }

    fun pickDate(date: String) {
        _order.update {
            it.copy(
                date = date,
                flavor = order.value.flavor,
                order = order.value.order,
                price = priceIt(order.value.flavor,order.value.order)
            )
        }
    }

    fun shareOrder(context: Context, orderSummary: String){
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "New Cupcake Order")
            putExtra(Intent.EXTRA_TEXT, orderSummary)
        }
        context.startActivity(
            Intent.createChooser(
                intent,
                "New Cupcake Order"
            )
        )
    }

    fun cancelOrder(){
        _order.update {
            it.copy(
                date = "",
                flavor = "",
                order = 0,
                price = priceIt("",0)
            )
        }
    }
}