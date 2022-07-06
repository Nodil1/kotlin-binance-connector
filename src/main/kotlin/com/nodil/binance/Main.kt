package com.nodil.binance

import com.nodil.binance.core.clients.FuturesClient
import com.nodil.binance.core.clients.SpotClient
import com.nodil.binance.core.models.KlineHistory
import com.nodil.binance.core.models.enums.KlineInterval
import com.nodil.binance.core.models.enums.TradeSide

fun main(args: Array<String>) {
    println(System.currentTimeMillis())
    val api = "ELfjgbbUQ9FJWlc7nj3J4VZt11xH16X3uR9DtpcPVFS3cm13VXtDf1iC71sIOxFe"
    val secret = "X7KfOQ3CcsRPWgleEy3xJW3Ykv7XcOpswQJg5V4gv3J5PdFN7I1P0zMarox5gjMu"
    val client = SpotClient(api, secret)
    println(client.getKlineHistory(KlineInterval.MINUTE_1, "ADAUSDT").size)

}