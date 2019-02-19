package io.anishbajpai.starter.storage.network

import com.google.gson.annotations.SerializedName

data class CallWrapper<T>(
    @SerializedName("message")
    val message: String = "",
    @SerializedName("request")
    val request: List<T>,
    @SerializedName("status")
    val status: Int = 0,
    @SerializedName("success")
    val success: Boolean = false,
    @SerializedName("timestamp")
    val timestamp: Int = 0
)