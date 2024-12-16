package com.example.unitconverter.ui.theme

import android.annotation.SuppressLint
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

    fun getValueToConvert(valueToConvert: String) {
        _uiState.update {
            it.copy(
                valueToConvert = valueToConvert,
            )
        }
    }

    fun getUnitToConvertFrom(toConvertFrom: String) {
        _uiState.update {
            it.copy(
                unitToConvertFrom = toConvertFrom
            )
        }
    }

    fun getUnitToConvertTo(toConvertTo: String) {
        _uiState.update {
            it.copy(
                unitToConvertTo = toConvertTo
            )
        }
    }

    fun clearFields() {
        _uiState.update {
            it.copy(
                valueToConvert = "",
                unitToConvertFrom = "",
                unitToConvertTo = ""
            )
        }
    }

    fun convert() {
        if (_uiState.value.isLengthButtonClicked) {
            convertFormLengthTo()
        } else if (_uiState.value.isWeightButtonClicked) {
            convertFromWeightTo()
        } else {
            convertFromTemperatureTo()
        }
    }

    @SuppressLint("DefaultLocale")
    private fun convertFormLengthTo() {
        if (_uiState.value.unitToConvertFrom.toLowerCase() == Length.CENTIMETRE.name &&
            _uiState.value.unitToConvertTo == Length.MILLIMETRE.name
        ) {
            FromCentimetreToMillimetre()
        }
    }

    private fun convertFromWeightTo() {

    }

    private fun convertFromTemperatureTo() {

    }
}