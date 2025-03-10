package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.DessertUiState
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()

    fun onDessert1Clicked() {
        _dessertUiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex1 = nextDessertIndex,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice1,
                dessertsSold = dessertsSold,
                currentDessertImageId1 = dessertList[nextDessertIndex].imageId,
                currentDessertPrice1 = dessertList[nextDessertIndex].price
            )
        }
    }

    fun onDessert2Clicked() {
        _dessertUiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex2 = nextDessertIndex,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice2,
                dessertsSold = dessertsSold,
                currentDessertImageId2 = dessertList[nextDessertIndex].imageId,
                currentDessertPrice2 = dessertList[nextDessertIndex].price
            )
        }
    }

    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
}

