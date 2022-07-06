package com.nodil.binance.core.clients

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.nodil.binance.core.models.requests.FutureTradeRequest

import com.nodil.binance.core.models.enums.TradeSide
import com.nodil.binance.core.models.enums.TradeTypes
import org.json.JSONArray
import org.json.JSONObject

class FuturesClient(api: String, secretKey: String) : BaseClient(api, secretKey) {

    fun newMarketOrder(symbol: String, volume: Float, side: TradeSide){
        val order = FutureTradeRequest(
            symbol = symbol,
            side = side.name,
            type = TradeTypes.MARKET.name,
            quantity = volume
        )
        val query = generateQuery(
            mapOf(
                "symbol" to order.symbol,
                "side" to order.side,
                "type" to order.type,
                "quantity" to order.quantity.toString(),
                "timestamp" to order.timestamp.toString()
            )
        )
        println(generateSignature(query))
        val (request, response, result) = "https://fapi.binance.com/fapi/v1/order"
            .httpPost(
                listOf(
                    "symbol" to order.symbol,
                    "side" to order.side,
                    "type" to order.type,
                    "quantity" to order.quantity,
                    "timestamp" to order.timestamp,
                    "signature" to generateSignature(query)
                )
            )
            .header("X-MBX-APIKEY", api)
            .responseString()


        when (result) {
            is Result.Failure -> {
                throw Exception(response.toString())
            }
            is Result.Success -> {
                val data = result.get()
            }
        }
    }

    fun getSymbolsInfo(): JSONArray {
        val (request, response, result) = "https://fapi.binance.com/fapi/v1/exchangeInfo"
            .httpGet()
            .responseString()

        when (result) {
            is Result.Failure -> {
                println(response)
            }
            is Result.Success -> {
                val data = JSONObject(result.get())
                return data.getJSONArray("symbols")
            }
        }
        throw Exception()
    }
}