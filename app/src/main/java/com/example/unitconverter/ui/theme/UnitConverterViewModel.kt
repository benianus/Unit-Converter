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

    fun convertButtonClicked() {
        _uiState.update {
            it.copy(
                isConvertButtonClicked = true
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

    fun reset() {
        _uiState.update {
            if (_uiState.value.isLengthButtonClicked) {
                it.copy(
                    isConvertButtonClicked = false,
                    isLengthButtonClicked = true,
                    result = ""
                )
            } else if (_uiState.value.isWeightButtonClicked) {
                it.copy(
                    isConvertButtonClicked = false,
                    isWeightButtonClicked = true,
                    result = ""
                )
            } else {
                it.copy(
                    isConvertButtonClicked = false,
                    isTemperatureButtonClicked = true,
                    result = ""
                )
            }
        }
    }

    fun convert() {
        if (_uiState.value.isLengthButtonClicked) {
            convertLengthFromTo()
        } else if (_uiState.value.isWeightButtonClicked) {
            convertWeightFromTo()
        } else {
            convertTemperatureFromTo()
        }
    }

    private fun convertLengthFromTo() {
        val unitToFrom = _uiState.value.unitToConvertFrom
        when (unitToFrom) {
            Length.CENTIMETRE.unit -> {
                fromCentimeterTo()
            }

            Length.MILLIMETRE.unit -> {
                fromMillimetreTo()
            }

            Length.METER.unit -> {
                fromMeterTo()
            }

            Length.KILOMETRE.unit -> {
                fromKilometreTo()
            }

            Length.INCH.unit -> {
                fromInchTo()
            }

            Length.FOOT.unit -> {
                fromFootTo()
            }

            Length.YARD.unit -> {
                fromYardTo()
            }

            else -> {
                fromMileTo()
            }
        }
    }

    private fun convertWeightFromTo() {
        val unitToFrom = _uiState.value.unitToConvertFrom
        when (unitToFrom) {
            Weight.MILLIGRAM.unit -> {
                fromMilligramTo()
            }

            Weight.GRAM.unit -> {
                fromGramTo()
            }

            Weight.KILOGRAM.unit -> {
                fromKilogramTo()
            }

            Weight.OUNCE.unit -> {
                fromOunceTo()
            }

            else -> {
                fromPoundTo()
            }
        }
    }

    private fun convertTemperatureFromTo() {
        val unitToFrom = _uiState.value.unitToConvertFrom
        when (unitToFrom) {
            Temperature.KELVIN.unit -> {}
            Temperature.CELSIUS.unit -> {}
            else -> {}
        }
    }

    private fun fromMilligramTo() {}
    private fun fromGramTo() {}
    private fun fromKilogramTo() {}
    private fun fromOunceTo() {}
    private fun fromPoundTo() {}

    private fun fromKelvinTo() {}
    private fun fromCelsiusTo() {}
    private fun fromFahrenheitTo() {}

    private fun fromCentimeterTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 10).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 100).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 100000).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 2.54).toString()
                    )
                }
            }

            Length.FOOT.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 30.48).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 91.44).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 160900).toString()
                    )
                }
            }
        }
    }

    private fun fromMillimetreTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 10).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1000).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1e6).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 25.4).toString()
                    )
                }
            }

            Length.FOOT.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 304.8).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 914.4).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1.609e6).toString()
                    )
                }
            }
        }
    }

    private fun fromMeterTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1000).toString()
                    )
                }
            }

            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 100).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1000).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 39.37).toString()
                    )
                }
            }

            Length.FOOT.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 3.281).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1.094).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1609).toString()
                    )
                }
            }
        }
    }

    private fun fromKilometreTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1e6).toString()
                    )
                }
            }

            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 100000).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1000).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 39370).toString()
                    )
                }
            }

            Length.FOOT.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 3281).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1094).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1.609).toString()
                    )
                }
            }
        }
    }

    private fun fromInchTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 25.4).toString()
                    )
                }
            }

            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 2.54).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 39.37).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 39370).toString()
                    )
                }
            }

            Length.FOOT.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 12).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 36).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 63360).toString()
                    )
                }
            }
        }
    }

    private fun fromYardTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 914.4).toString()
                    )
                }
            }

            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 91.44).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1.094).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1094).toString()
                    )
                }
            }

            Length.FOOT.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 3).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 36).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 1760).toString()
                    )
                }
            }
        }
    }

    private fun fromFootTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 304.8).toString()
                    )
                }
            }

            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 30.48).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 3.281).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 3281).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 3).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 12).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() / 5280).toString()
                    )
                }
            }
        }
    }

    private fun fromMileTo() {
        val unitToTo = _uiState.value.unitToConvertTo
        when (unitToTo) {
            Length.MILLIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1.609e6).toString()
                    )
                }
            }

            Length.CENTIMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 160900).toString()
                    )
                }
            }

            Length.METER.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1609).toString()
                    )
                }
            }

            Length.KILOMETRE.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1.609).toString()
                    )
                }
            }

            Length.YARD.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 1760).toString()
                    )
                }
            }

            Length.INCH.unit -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 63360).toString()
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        result = (_uiState.value.valueToConvert.toDouble() * 5280).toString()
                    )
                }
            }
        }
    }


}