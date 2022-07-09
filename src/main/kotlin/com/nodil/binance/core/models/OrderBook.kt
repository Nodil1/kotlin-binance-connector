package com.nodil.binance.core.models

class OrderBook{
    private var asks = mutableMapOf<Float, Float>()
    private var bids = mutableMapOf<Float, Float>()

    fun getAsks(): Map<Float, Float> {
        return asks.toMap()
    }
    fun getBids(): Map<Float, Float> {
        return bids.toMap()
    }

    fun addAsk(price: Float, volume: Float){
        asks[price] = volume
    }

    fun addAsk(asks: Map<Float, Float>) {
        this.asks = asks.toMutableMap()
    }

    fun addBid(price: Float, volume: Float){
        bids[price] = volume
    }

    fun addBid(addBid: Map<Float, Float>) {
        this.bids = bids.toMutableMap()
    }
}