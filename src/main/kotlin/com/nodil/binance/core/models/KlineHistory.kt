package com.nodil.binance.core.models

import org.json.JSONArray

data class KlineHistory(
    val openTime: Long,
    val open: Float,
    val high: Float,
    val low: Float,
    val close: Float,
    val volume: Float,
    val closeTime: Long,
    val quoteAssetVolume: Float,
    val numberOfTrades: Long,
    val takerBuyBase: Float,
    val takerBuyQuote: Float,
    val unknown: Float
) {
    companion object{
        fun fromJsonArray(tmpArr: JSONArray): KlineHistory{
                return KlineHistory(
                    tmpArr.getLong(0),
                    tmpArr.getString(1).toFloat(),
                    tmpArr.getString(2).toFloat(),
                    tmpArr.getString(3).toFloat(),
                    tmpArr.getString(4).toFloat(),
                    tmpArr.getString(5).toFloat(),
                    tmpArr.getLong(6),
                    tmpArr.getString(7).toFloat(),
                    tmpArr.getLong(8),
                    tmpArr.getString(9).toFloat(),
                    tmpArr.getString(10).toFloat(),
                    tmpArr.getString(11).toFloat(),
                )
        }
    }
}