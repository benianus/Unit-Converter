package com.example.unitconverter.ui.theme

data class UnitConverterUiState(
    val isLengthButtonClicked: Boolean = true,
    val isWeightButtonClicked: Boolean = false,
    val isTemperatureButtonClicked: Boolean = false,
    val valueToConvert: String = "",
    val unitToConvertFrom: String = "",
    val unitToConvertTo: String = ""
)
