package com.nodil.binance.core.streams

import com.nodil.binance.core.WebSocketStream
import com.nodil.binance.core.models.Kline
import io.ktor.client.plugins.websocket.*

class CandleStickStream(
    interval: String,
    symbol: String,
) : WebSocketStream("kline_$interval", symbol) {
    private lateinit var onReceive: (kline: Kline) -> Unit
    private lateinit var onKlineClose: (kline: Kline) -> Unit

    override suspend fun onDataReceived(webSocketSession: DefaultClientWebSocketSession) {
        with(webSocketSession) {
            val kline = receiveDeserialized<Kline>()
            if (kline.k.isClosed){
                onKlineClose(kline)
            }
            onReceive(kline)

        }
    }

    fun onKlineClose(callback: (kline: Kline) -> Unit) {
        onKlineClose = callback
    }
    fun onReceive(callback:(kline: Kline) -> Unit){
        onReceive =  callback
    }
}