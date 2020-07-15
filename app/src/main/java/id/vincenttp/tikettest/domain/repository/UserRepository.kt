package id.vincenttp.tikettest.domain.repository

import id.vincenttp.tikettest.domain.entity.UserEntity

/**
 * Created by vincenttp on 13/07/20.
 */
interface UserRepository {
    suspend fun getUser(): List<UserEntity>
}