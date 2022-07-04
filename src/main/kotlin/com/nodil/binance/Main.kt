package com.nodil.binance

import com.nodil.binance.core.clients.FuturesClient
import com.nodil.binance.core.models.KlineInterval
import com.nodil.binance.core.models.enums.TradeSide
import com.nodil.binance.core.streams.CandleStickStream

fun main(args: Array<String>) {
    println(System.currentTimeMillis())
    val api = "ELfjgbbUQ9FJWlc7nj3J4VZt11xH16X3uR9DtpcPVFS3cm13VXtDf1iC71sIOxFe"
    val secret = "X7KfOQ3CcsRPWgleEy3xJW3Ykv7XcOpswQJg5V4gv3J5PdFN7I1P0zMarox5gjMu"
    val client = FuturesClient(api, secret)
    client.newMarketOrder("ADAUSDT", 100f, TradeSide.SELL)

}