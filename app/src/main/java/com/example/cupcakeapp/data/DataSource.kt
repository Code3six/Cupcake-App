package com.example.cupcakeapp.data

import com.example.cupcakeapp.data.model.Flavor

object DataSource {
    val flavors = listOf(
        Flavor("Vanilla",2),
        Flavor("Chocolate",2),
        Flavor("Red Velvet", 5),
        Flavor("Salted Caramel", 5),
        Flavor("Coffee", 1)
    )
    val dates = listOf(
        "Sun Jul 3",
        "Mon Jul 4",
        "Tue Jul 5",
        "Wed Jul 6"
    )
}