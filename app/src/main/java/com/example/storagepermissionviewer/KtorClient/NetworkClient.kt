package com.example.storagepermissionviewer.KtorClient

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.utils.io.InternalAPI

object NetworkClient {
    val client = HttpClient(CIO)
}

@OptIn(InternalAPI::class)
suspend fun fetchSum(num1: Int, num2: Int): String {
    return try {
        val response = HttpClient(CIO).get("http://localhost:8080/add") {
            url {
                parameters.append("num1", num1.toString())
                parameters.append("num2", num2.toString())
            }
        }
        response.bodyAsText()
    } catch (e: Exception) {
        "Error: ${e.localizedMessage}"
    }
}