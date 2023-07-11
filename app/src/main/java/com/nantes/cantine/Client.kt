package com.nantes.cantine

import com.nantes.cantine.models.Menu
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import kotlinx.serialization.*
import kotlinx.serialization.json.Json


class Client {
    val client = OkHttpClient()

    @Throws(IOException::class)
    fun run(url: String): Menu {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response ->
            val string = Json.encodeToString(response.body)
            println(string)
            val obj = Json.decodeFromString<Menu>(string)
            println(obj)

            return obj
        }
    }
}