package com.example.stylosenses.datas.dummy_db

import androidx.compose.ui.graphics.Color
import com.example.stylosenses.domains.models.ProductModel
import com.example.stylosensess.R
import javax.inject.Inject

class DemoDB @Inject constructor() {
    private val description =
        "Wireless Controller for PS4™ gives you what you want in your gaming from over precision control your games to sharing …"


    fun getProduct(): List<ProductModel> {
        return listOf(
            ProductModel(
                id = 1,
                title = "Taylor",
                description = description,
                images = listOf(
                    R.drawable.image_popular_product_1,
//                    R.drawable.ps4_console_white_1,
//                    R.drawable.ps4_console_white_2,
//                    R.drawable.ps4_console_white_3,
//                    R.drawable.ps4_console_white_4,
                ),
                colors = listOf(
                    Color(0xFFF6625E),
                    Color(0xFF836DB8),
                    Color(0xFFDECB9C),
                    Color.White,
                ),
                rating = 0.0,
                price = "Lihat Selengkapnya",
                isFavourite = true,
                isPopular = true,

                ),

            //second product

            ProductModel(
                id = 2,
                title = "Laundry",
                description = description,
                images = listOf(
                    R.drawable.image_popular_product_2
                ),
                colors = listOf(
                    Color(0xFFF6625E),
                    Color(0xFF836DB8),
                    Color(0xFFDECB9C),
                    Color.White,
                ),
//                rating = 4.1,
                rating = 0.0,
//                price = 49.99,
                price = "Lihat Selengkapnya",
                isFavourite = true,
                isPopular = true,

                ),

            //third product
//            ProductModel(
//                id = 3,
//                title = "Gloves XC Omega - Polygon",
//                description = description,
//                images = listOf(
//                    R.drawable.glove
//                ),
//                colors = listOf(
//                    Color(0xFFF6625E),
//                    Color(0xFF836DB8),
//                    Color(0xFFDECB9C),
//                    Color.White,
//                ),
//                rating = 4.1,
//                price = 36.55,
//                isFavourite = true,
//                isPopular = true,
//
//                ),

//            ProductModel(
//                id = 4,
//                title = "Gloves XC Omega - Polygon",
//                description = description,
//                images = listOf(
//                    R.drawable.wireless_headset
//                ),
//                colors = listOf(
//                    Color(0xFFF6625E),
//                    Color(0xFF836DB8),
//                    Color(0xFFDECB9C),
//                    Color.White,
//                ),
//                rating = 4.1,
//                price = 19.99,
//                isFavourite = true,
//                isPopular = true,
//
//                ),


            )

    }
}