package com.nodil.binance.core.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Trade(
    @SerialName("e")
    val event: String,
    @SerialName("E")
    val eventId: Long,
    @SerialName("s")
    val symbol: String,
    @SerialName("t")
    val tradeId: Long,
    @SerialName("p")
    val price: Float,
    @SerialName("q")
    val volume: String,
    @SerialName("b")
    val buyerId: Long,
    @SerialName("a")
    val sellerId: Long,
    @SerialName("T")
    val time: Long,
    @SerialName("m")
    val isBuyer: Boolean,
    @SerialName("M")
    val ignore: Boolean
)