package com.example.storagepermissionviewer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BasicTextFieldImplementation(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        var textValue = remember { mutableStateOf("") }
        BasicTextField(
            value = textValue.value,
            onValueChange = { textValue.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(5.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color.LightGray),
            singleLine = true,
            textStyle = MaterialTheme.typography.titleLarge.copy(Color.Black),
            visualTransformation = VisualTransformation.None,
            cursorBrush = SolidColor(Color.Black),
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrectEnabled = true,
                showKeyboardOnFocus = true,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { navController.navigate("home") }),

        );Unit

    }

}