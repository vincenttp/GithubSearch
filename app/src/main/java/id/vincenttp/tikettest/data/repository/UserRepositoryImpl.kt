package id.vincenttp.tikettest.data.repository

import id.vincenttp.tikettest.data.api.UserApi
import id.vincenttp.tikettest.data.base.transform
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.repository.UserRepository

/**
 * Created by vincenttp on 13/07/20.
 */
class UserRepositoryImpl(private val api: UserApi) :
    UserRepository {
    override suspend fun getUser(): List<UserEntity> = api.getUsers().map(::transform)
}