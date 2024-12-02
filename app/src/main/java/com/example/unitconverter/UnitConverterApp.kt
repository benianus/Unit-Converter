package com.example.unitconverter

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.ui.theme.UnitConverterViewModel
import com.example.unitconverter.ui.theme.screens.LengthScreen
import com.example.unitconverter.ui.theme.screens.TemperatureScreen
import com.example.unitconverter.ui.theme.screens.WeightScreen
import com.example.unitconverter.ui.theme.theme.UnitConverterTheme

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
        ConvertUnitsBar(
            viewModel = viewModel,
            modifier = Modifier
                .padding(it),
            isLengthButtonClicked = uiState.isLengthButtonClicked,
            isWeightButtonClicked = uiState.isWeightButtonClicked,
            isTemperatureButtonClicked = uiState.isTemperatureButtonClicked
        )

        if (uiState.isShowingLengthPage) {
            LengthScreen(

            )
            viewModel.lengthButtonClicked()
        } else if (uiState.isShowingWeightPage) {
            WeightScreen(

            )
            viewModel.weightButtonClicked()
        } else {
            TemperatureScreen(

            )
            viewModel.temperatureButtonClicked()
        }
    }
}

@Composable
private fun ConvertUnitsBar(
    viewModel: UnitConverterViewModel,
    modifier: Modifier = Modifier,
    isLengthButtonClicked: Boolean = true,
    isWeightButtonClicked: Boolean = false,
    isTemperatureButtonClicked: Boolean = false
) {
    Row(
        modifier = modifier
            .padding(16.dp)
    ) {
        LengthButton(
            viewModel = viewModel,
            isLengthButtonClicked = isLengthButtonClicked
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        WeightButton(
            viewModel = viewModel,
            isWeightButtonClicked = isWeightButtonClicked
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        TemperatureButton(
            viewModel,
            modifier = Modifier.weight(1f),
            isTemperatureButtonClicked = isTemperatureButtonClicked
        )
    }
}

@Composable
private fun TemperatureButton(
    viewModel: UnitConverterViewModel,
    modifier: Modifier = Modifier,
    isTemperatureButtonClicked: Boolean = false
) {
    if (isTemperatureButtonClicked) {
        OutlinedButton(
            onClick = {
                viewModel.showingTemperaturePage()
            },
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.temperature)
            )
        }
    } else {
        Button(
            onClick = {
                viewModel.showingTemperaturePage()
            },
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.temperature)
            )
        }
    }
}

@Composable
private fun WeightButton(
    viewModel: UnitConverterViewModel,
    modifier: Modifier = Modifier,
    isWeightButtonClicked: Boolean = false
) {
    if (isWeightButtonClicked) {
        OutlinedButton(
            onClick = {
                viewModel.showingWeightPage()
            },
        ) {
            Text(
                text = stringResource(R.string.weight)
            )
        }
    } else {
        Button(
            onClick = {
                viewModel.showingWeightPage()
            },
        ) {
            Text(
                text = stringResource(R.string.weight)
            )
        }
    }
}

@Composable
private fun LengthButton(
    viewModel: UnitConverterViewModel,
    modifier: Modifier = Modifier,
    isLengthButtonClicked: Boolean = true
) {
    if (isLengthButtonClicked) {
        OutlinedButton(
            onClick = {
                viewModel.showingLengthPage()
            },
        ) {
            Text(
                text = stringResource(R.string.length)
            )
        }
    } else {
        Button(
            onClick = {
                viewModel.showingLengthPage()
            },
        ) {
            Text(
                text = stringResource(R.string.length)
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

@Preview
@Composable
fun ConvertUintBarPreview() {
    UnitConverterTheme {

    }
}