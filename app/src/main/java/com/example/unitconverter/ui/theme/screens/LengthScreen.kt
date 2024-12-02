package com.example.unitconverter.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R

@Composable
fun LengthScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FieldAndText(
            fieldText = stringResource(R.string.enter_the_length_to_convert)
        )
        FieldAndText(
            fieldText = stringResource(R.string.unit_to_convert_from)
        )
        FieldAndText(
            fieldText = stringResource(R.string.unit_to_convert_to)
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

@Composable
fun FieldAndText(
    fieldText: String
) {
    var value by rememberSaveable() { mutableStateOf("") }

    Text(
        text = fieldText,
        style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(16.dp))
    TextField(
        value = value,
        onValueChange = { value = it},
        modifier = Modifier
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LengthScreenPreview() {
    LengthScreen()
}