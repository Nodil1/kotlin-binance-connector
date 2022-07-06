package com.nodil.binance.core.models.requests

import java.sql.Timestamp

@kotlinx.serialization.Serializable
data class FutureTradeRequest(
    val symbol: String,
    val side: String,
    val type: String,
    val quantity: Float,
    val timestamp: Long = System.currentTimeMillis()
)