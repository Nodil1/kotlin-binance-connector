package core.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kline(
    @SerialName("e")
    val event: String,
    @SerialName("E")
    val eventId: Long,
    @SerialName("s")
    val symbol: String,
    @SerialName("k")
    val k: KlineData
)