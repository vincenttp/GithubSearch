package id.vincenttp.tikettest.data

import id.vincenttp.tikettest.domain.UserEntity
import id.vincenttp.tikettest.domain.UserRepository

/**
 * Created by vincenttp on 13/07/20.
 */
class UserDataRepository(private val api: UserApi) : UserRepository {
    override suspend fun getUser(): List<UserEntity> = api.getUsers().map {
        UserEntity(
            it.login.orEmpty(),
            it.id ?: 0,
            it.avatar_url.orEmpty()
        )
    }
}