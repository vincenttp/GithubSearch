package id.vincenttp.tikettest.domain.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Created by vincenttp on 13/07/20.
 */
abstract class BaseUseCase<Entity> {
    abstract suspend fun build(): Entity
    suspend fun invoke(context: CoroutineContext = Dispatchers.IO) = withContext(context) {
        either { build() }
    }
}

suspend fun <V> either(block: suspend () -> V): Result<V> = runCatching {
    Result.Success(block())
}.getOrElse {
    Result.Error(Exception(it))
}