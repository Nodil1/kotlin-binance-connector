package core.streams

import core.WebSocketStream
import core.models.Kline
import core.models.KlineInterval
import io.ktor.client.plugins.websocket.*
import java.text.DateFormatSymbols

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