import core.WebSocketStream
import core.models.KlineInterval
import core.streams.CandleStickStream

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