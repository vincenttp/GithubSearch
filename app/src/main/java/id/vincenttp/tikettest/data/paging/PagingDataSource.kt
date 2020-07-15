package id.vincenttp.tikettest.data.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import id.vincenttp.tikettest.domain.base.Result
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created by vincenttp on 16/07/20.
 */
class PagingDataSource(private val repository: UserRepository, private val q: String) :
    ItemKeyedDataSource<Int, UserEntity>() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var key = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<UserEntity>
    ) {
        coroutineScope.launch {
            invoke {
                when (it) {
                    is Result.Success<List<UserEntity>> -> {
                        if (it.data.isNotEmpty()) {
                            callback.onResult(it.data)
                        } else {
                            ERROR_MESSAGE.postValue("No Matching Account")
                        }
                    }
                    is Result.Error -> {
                        errorHandling(it.exception)
                    }
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<UserEntity>) {
        coroutineScope.launch {
            invoke {
                when (it) {
                    is Result.Success<List<UserEntity>> -> {
                        if (it.data.isNotEmpty()) {
                            callback.onResult(it.data)
                        } else {
                            ERROR_MESSAGE.postValue("No Matching Account")
                        }
                    }
                    is Result.Error -> {
                        errorHandling(it.exception)
                    }
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<UserEntity>) {
        // disable loadBefore
    }

    override fun getKey(item: UserEntity): Int = key

    private fun invoke(result: (Result<List<UserEntity>>) -> Unit) {
        key++
        coroutineScope.launch {
            result(either { repository.getUser(q, key) })
        }
    }

    private fun errorHandling(e: Exception) {
        when (e) {
            is HttpException -> ERROR_MESSAGE.postValue("Code = ${e.code()} Message = ${e.message()}")
            else -> ERROR_MESSAGE.postValue(e.message ?: "Unexpected Error")
        }
    }

    companion object{
        val ERROR_MESSAGE = MutableLiveData<String>()
    }
}

suspend fun <V> either(block: suspend () -> V): Result<V> = runCatching {
    Result.Success(block())
}.getOrElse {
    Result.Error(Exception(it))
}