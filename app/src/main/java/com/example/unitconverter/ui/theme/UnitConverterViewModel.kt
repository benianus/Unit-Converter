package com.example.unitconverter.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UnitConverterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UnitConverterUiState())
    val uiState: StateFlow<UnitConverterUiState> = _uiState.asStateFlow()

    fun lengthButtonClicked() {
        _uiState.update {
            it.copy(
                isLengthButtonClicked = true,
                isWeightButtonClicked = false,
                isTemperatureButtonClicked = false
            )
        }
    }

    fun weightButtonClicked() {
        _uiState.update {
            it.copy(
                isLengthButtonClicked = false,
                isWeightButtonClicked = true,
                isTemperatureButtonClicked = false
            )
        }
    }

    fun temperatureButtonClicked() {
        _uiState.update {
            it.copy(
                isLengthButtonClicked = false,
                isWeightButtonClicked = false,
                isTemperatureButtonClicked = true
            )
        }
    }

    fun reset() {
        _uiState.update {
            it.copy(

            )
        }
    }
}