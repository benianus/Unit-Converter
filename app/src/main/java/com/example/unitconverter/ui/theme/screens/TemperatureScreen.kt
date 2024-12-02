package com.example.unitconverter.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R

@Composable
fun TemperatureScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FieldAndText(
            fieldText = stringResource(R.string.enter_the_temperature_to_convert)
        )
        FieldAndText(
            fieldText = stringResource(id = R.string.unit_to_convert_from)
        )
        FieldAndText(
            fieldText = stringResource(id = R.string.unit_to_convert_to)
        )
        Button(
            onClick = {},
        ) {
            Text(
                text = stringResource(R.string.convert_button)
            )
        }
    }
}