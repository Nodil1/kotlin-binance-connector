package com.nodil.binance

import com.nodil.binance.core.models.KlineInterval
import com.nodil.binance.core.streams.CandleStickStream

fun main(args: Array<String>) {
    val stream = CandleStickStream(KlineInterval.MINUTE_1, "adausdt")
    stream.onKlineClose {
        println(it)
        println("Close")
    }
    stream.onReceive {
        println(it)
    }
    stream.run()

}