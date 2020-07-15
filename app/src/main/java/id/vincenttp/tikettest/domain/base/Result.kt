package id.vincenttp.tikettest.domain.base

/**
 * Created by vincenttp on 13/07/20.
 */

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}