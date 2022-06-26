package core.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KlineData(
    @SerialName("t")
    val startTime: Long,
    @SerialName("T")
    val closeTime: Long,
    @SerialName("s")
    val symbol: String,
    @SerialName("i")
    val interval: String,
    @SerialName("f")
    val firstTrade: Long,
    @SerialName("L")
    val lastTrade: Long,
    @SerialName("o")
    val openPrice: Float,
    @SerialName("c")
    val closePrice: Float,
    @SerialName("h")
    val highPrice: Float,
    @SerialName("l")
    val lowPrice: Float,
    @SerialName("v")
    val volume: Float,
    @SerialName("n")
    val tradeCount: Long,
    @SerialName("x")
    val isClosed: Boolean,
    @SerialName("q")
    val volumeQuote: Float,
    @SerialName("V")
    val takerBaseVolume: Float,
    @SerialName("Q")
    val takerQuoteVolume: Float,
    @SerialName("B")
    val b: Long
)
