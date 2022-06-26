package core

import core.models.Trade
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.*
import io.ktor.websocket.*
import kotlinx.coroutines.runBlocking
import io.ktor.serialization.kotlinx.*
import kotlinx.serialization.json.*
import okhttp3.OkHttp
import okhttp3.OkHttpClient

import java.util.*
import kotlin.system.measureTimeMillis

abstract class WebSocketStream(
    val streamName: String,
    val symbolName: String
) {
    private val client = HttpClient() {
        install(WebSockets) {
            contentConverter = KotlinxWebsocketSerializationConverter(Json)

        }
        install(HttpTimeout) {
            requestTimeoutMillis = HttpTimeout.INFINITE_TIMEOUT_MS
            connectTimeoutMillis = HttpTimeout.INFINITE_TIMEOUT_MS
            socketTimeoutMillis = HttpTimeout.INFINITE_TIMEOUT_MS
        }
    }
    fun run() {
        runBlocking {
            client.wss(method = HttpMethod.Get, host = "stream.binance.com", port = 9443, path = "/ws/$symbolName@$streamName") {
                while (true) {
                    val time = measureTimeMillis {
                        onDataReceived(this)
                    }
                    println(time)
                }
            }
        }
        client.close()
    }
    abstract suspend fun onDataReceived(webSocketSession: DefaultClientWebSocketSession)


}