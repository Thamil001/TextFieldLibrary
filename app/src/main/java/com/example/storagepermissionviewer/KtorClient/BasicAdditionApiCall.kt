package com.example.storagepermissionviewer.KtorClient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun AddNumbersScreen() {

    // State variables for user input and API response
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    // Coroutine scope for network call
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color= Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Enter Two Numbers")

        Spacer(modifier = Modifier.height(16.dp))

        // Input fields for numbers
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Number 1") },
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Number 2") },
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to call the API
        Button(
            onClick = {
                val n1 = num1.toIntOrNull()
                val n2 = num2.toIntOrNull()
                if (n1 != null && n2 != null) {
                    scope.launch(Dispatchers.IO) {
                        result = fetchSum(n1, n2)
                       // Call API
                    }

                } else {
                    result = "Invalid input! Please enter numbers."
                }
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Get Sum")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the result
        Text("Result: $result")

    }
}