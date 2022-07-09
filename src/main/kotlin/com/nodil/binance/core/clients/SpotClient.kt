package com.nodil.binance.core.clients

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.nodil.binance.core.models.KlineHistory
import org.json.JSONArray

class SpotClient(api: String, secretKey: String) : BaseClient(api, secretKey) {
   private val baseUrl = "https://api.binance.com/api"
   private val klineHistoryUrl = "/v3/klines"
   private val orderBook = "/v3/depth"

   fun getKlineHistory(interval: String, symbol: String): Array<KlineHistory> {
      val (request, response, result) = "${baseUrl}${klineHistoryUrl}"
         .httpGet(
            listOf(
               "symbol" to symbol,
               "interval" to interval,
               "limit" to 1000
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
            val history = mutableListOf<KlineHistory>()
            val jsonArr = JSONArray(data)
            for (i in 0 until jsonArr.length()){
               val tmpArr = jsonArr.getJSONArray(i)
               history.add(KlineHistory.fromJsonArray(tmpArr))
            }
            return history.toTypedArray()
         }
      }
   }

   fun getOrderBook(interval: String, symbol: String): Array<KlineHistory> {
      val (request, response, result) = "${baseUrl}${klineHistoryUrl}"
         .httpGet(
            listOf(
               "symbol" to symbol,
               "interval" to interval,
               "limit" to 1000
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
            val history = mutableListOf<KlineHistory>()
            val jsonArr = JSONArray(data)
            for (i in 0 until jsonArr.length()){
               val tmpArr = jsonArr.getJSONArray(i)
               history.add(KlineHistory.fromJsonArray(tmpArr))
            }
            return history.toTypedArray()
         }
      }
   }
}