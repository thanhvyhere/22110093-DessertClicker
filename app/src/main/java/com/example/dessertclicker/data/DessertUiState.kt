package com.example.dessertclicker.data

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex1: Int = 0,
    val currentDessertImageId1: Int = dessertList[0].imageId,
    val currentDessertPrice1: Int = dessertList[0].price,
    val currentDessertIndex2: Int = 0,
    val currentDessertImageId2: Int = dessertList[0].imageId,
    val currentDessertPrice2: Int = dessertList[0].price
)
