package id.vincenttp.tikettest.data.paging

import androidx.paging.ItemKeyedDataSource
import id.vincenttp.tikettest.domain.base.Result
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by vincenttp on 16/07/20.
 */
class PostsDataSource(private val repository: UserRepository) :
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
                        callback.onResult(it.data)
                    }
                    is Result.Error -> {
                        it.exception.printStackTrace()
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
                        callback.onResult(it.data)
                    }
                    is Result.Error -> {
                        it.exception.printStackTrace()
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
            result(either { repository.getUser() })
        }
    }
}

suspend fun <V> either(block: suspend () -> V): Result<V> = runCatching {
    Result.Success(block())
}.getOrElse {
    Result.Error(Exception(it))
}