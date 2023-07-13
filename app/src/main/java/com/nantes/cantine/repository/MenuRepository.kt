package com.nantes.cantine.repository

import com.nantes.cantine.models.Menu
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class MenuRepository() {
    private val loginUrl = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_menus-cantines-scolaires-nantes&q=&sort=date&facet=type_menu&timezone=Europe%2FParis"

    // Function that makes the network request, blocking the current thread
    fun makeMenuRequest(
        jsonBody: String
    ): Result<Menu> {
        val url = URL(loginUrl)
        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("Accept", "application/json")
            doOutput = true
            outputStream.write(jsonBody.toByteArray())
            return Result.Success(Json.decodeFromString<Menu>(
                String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
                )))
        }
        return Result.Error(Exception("Cannot open HttpURLConnection"))
    }
}