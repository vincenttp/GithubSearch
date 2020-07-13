package id.vincenttp.tikettest.domain

/**
 * Created by vincenttp on 13/07/20.
 */
interface UserRepository {
    suspend fun getUser(): List<UserEntity>
}