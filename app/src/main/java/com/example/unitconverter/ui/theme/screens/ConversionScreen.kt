package com.example.unitconverter.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R
import com.example.unitconverter.ui.theme.UnitConverterUiState
import com.example.unitconverter.ui.theme.UnitConverterViewModel

@Composable
fun ConversionScreen(
    uiState: UnitConverterUiState,
    viewModel: UnitConverterViewModel,
    actualScreenName: String,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FieldAndText(
            value = uiState.valueToConvert,
            getValue = viewModel::getValueToConvert,
            fieldText = actualScreenName,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number
        )
        FieldAndText(
            value = uiState.unitToConvertFrom,
            getValue = viewModel::getUnitToConvertFrom,
            fieldText = stringResource(R.string.unit_to_convert_from),
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        )
        FieldAndText(
            value = uiState.unitToConvertTo,
            getValue = viewModel::getUnitToConvertTo,
            fieldText = stringResource(R.string.unit_to_convert_to),
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            onDone = { viewModel.convert() },
            isDone = true
        )
        Row {
            // convert button
            Button(
                onClick = {
                    viewModel.convertButtonClicked()
                    viewModel.convert()
                },
            ) {
                Text(
                    text = stringResource(R.string.convert_button)
                )
            }
            Spacer(modifier.width(16.dp))
            // clear button
            Button(
                onClick = {
                    viewModel.clearFields()
                },
            ) {
                Text(
                    text = stringResource(R.string.clear)
                )
            }
        }
    }
}

@Composable
fun FieldAndText(
    isDone: Boolean = false,
    onDone: () -> Unit = {},
    value: String,
    getValue: (String) -> Unit,
    fieldText: String,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    Text(
        text = fieldText,
        style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(16.dp))
    TextField(
        value = value,
        onValueChange = { getValue(it) },
        modifier = Modifier
            .fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = { if (isDone) onDone() else null }
        )
    )
    Spacer(modifier = Modifier.height(16.dp))
}
