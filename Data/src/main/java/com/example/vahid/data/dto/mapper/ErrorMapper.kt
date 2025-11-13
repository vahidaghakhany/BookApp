package com.example.vahid.data.dto.mapper

import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun mapErrorMessage(t: Throwable): String {
    return when (t) {
        is UnknownHostException -> "No internet connection"
        is SocketTimeoutException -> "Request timeout"
        else -> "Unknown error occurred"
    }
}
