package com.example.unitconverter

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.ui.theme.UnitConverterUiState
import com.example.unitconverter.ui.theme.UnitConverterViewModel
import com.example.unitconverter.ui.theme.screens.ConversionScreen
import com.example.unitconverter.ui.theme.screens.ResultScreen

@Composable
fun UnitConverterApp(
    modifier: Modifier = Modifier
) {
    val viewModel: UnitConverterViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            UnitConverterTopAppBar()
        }
    ) {

        LazyColumn(
            state = rememberLazyListState()
        ) {
            item {
                ConvertUnitsBar(
                    viewModel = viewModel,
                    modifier = Modifier
                        .padding(it),
                    uiState = uiState
                )
                if(uiState.isConvertButtonClicked) {
                    ResultScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                } else {
                    if (uiState.isLengthButtonClicked) {
                        ConversionScreen(
                            uiState = uiState,
                            viewModel = viewModel,
                            actualScreenName = stringResource(R.string.enter_the_length_to_convert)
                        )
                    } else if (uiState.isWeightButtonClicked) {
                        ConversionScreen(
                            uiState = uiState,
                            viewModel = viewModel,
                            actualScreenName = stringResource(R.string.enter_the_weight_to_convert)
                        )
                    } else {
                        ConversionScreen(
                            uiState = uiState,
                            viewModel = viewModel,
                            actualScreenName = stringResource(R.string.enter_the_temperature_to_convert)
                        )
                    }
                }
            }
        }



    }
}

@Composable
private fun ConvertUnitsBar(
    viewModel: UnitConverterViewModel,
    modifier: Modifier = Modifier,
    uiState: UnitConverterUiState
) {
    Row(
        modifier = modifier
            .padding(16.dp)
    ) {
        ConversionButton(
            clear = { viewModel.clearFields() },
            unitName = stringResource(R.string.length),
            onClick = {
                viewModel.lengthButtonClicked()
            },
            isButtonClicked = uiState.isLengthButtonClicked,
            modifier = Modifier
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        ConversionButton(
            clear = { viewModel.clearFields() },
            unitName = stringResource(R.string.weight),
            onClick = {
                viewModel.weightButtonClicked()
            },
            isButtonClicked = uiState.isWeightButtonClicked,
            modifier = Modifier
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        ConversionButton(
            clear = { viewModel.clearFields() },
            unitName = stringResource(R.string.temperature),
            onClick = { viewModel.temperatureButtonClicked() },
            isButtonClicked = uiState.isTemperatureButtonClicked,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ConversionButton(
    clear: () -> Unit,
    unitName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isButtonClicked: Boolean = true
) {
    if (isButtonClicked) {
        OutlinedButton(
            onClick = {
                clear()
                onClick()
            },
            modifier = modifier
        ) {
            Text(
                text = unitName
            )
        }
    } else {
        Button(
            onClick = {
                clear()
                onClick()
            },
            modifier = modifier
        ) {
            Text(
                text = unitName
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UnitConverterTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )
}
