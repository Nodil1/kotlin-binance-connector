package com.nodil.binance.core.clients

import org.apache.commons.codec.binary.Hex
import java.util.*
import javax.crypto.Mac
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

abstract class BaseClient(
    val api: String,
    val secretKey: String
) {

    protected fun generateSignature(data: String): String {
        val sha256Hmac = Mac.getInstance("HmacSHA256")
        val secretKey = SecretKeySpec(secretKey.toByteArray(), "HmacSHA256")
        sha256Hmac.init(secretKey)
        return Hex.encodeHexString(sha256Hmac.doFinal(data.toByteArray()))
    }
    protected fun generateQuery(map: Map<String, String>): String{
        var result = ""
        var i = 0
        map.onEach {
            if (i == 0){
                result += "${it.key}=${it.value}"
                i++
            } else{
                result += "&${it.key}=${it.value}"
            }
        }
        println(result)
        return result
    }
}