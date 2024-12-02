package com.example.unitconverter.ui.theme

data class UnitConverterUiState(
    val isShowingLengthPage: Boolean = true,
    val isShowingWeightPage: Boolean = false,
    val isShowingTemperature: Boolean = false,
    val isLengthButtonClicked: Boolean = true,
    val isWeightButtonClicked: Boolean = false,
    val isTemperatureButtonClicked: Boolean = false
)
