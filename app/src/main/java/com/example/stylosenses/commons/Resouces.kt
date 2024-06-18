package com.example.stylosenses.commons

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>() : Resource<T>()
    class Success<T>(data: T? = null) : Resource<T>(data = data)
    class Error<T>(message: String? = null) : Resource<T>(message = message)
}


//sealed class Resource<out T> {
//    data class Loading(val progress: Int = 0) : Resource<Nothing>()
//    data class Success<out T>(val data: T) : Resource<T>()
//    data class Error(val message: String, val cause: Throwable? = null) : Resource<Nothing>()
//
//    companion object {
//        fun loading(progress: Int = 0): Resource<Nothing> = Loading(progress)
//        fun <T> success(data: T): Resource<T> = Success(data)
//        fun error(message: String, cause: Throwable? = null): Resource<Nothing> = Error(message, cause)
//    }
//}