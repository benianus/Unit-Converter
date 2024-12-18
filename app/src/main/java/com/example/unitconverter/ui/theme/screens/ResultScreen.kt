package com.example.unitconverter.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R
import com.example.unitconverter.ui.theme.UnitConverterUiState
import com.example.unitconverter.ui.theme.UnitConverterViewModel

@Composable
fun ResultScreen(
    viewModel: UnitConverterViewModel,
    uiState: UnitConverterUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.result_of_your_calculation),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "${uiState.valueToConvert} ${uiState.unitToConvertFrom} =" +
                    " ${uiState.result} ${uiState.unitToConvertTo}",
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.reset()
                viewModel.clearFields()
            }
        ) {
            Text(text = "Reset")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ResultScreenPreview() {

}