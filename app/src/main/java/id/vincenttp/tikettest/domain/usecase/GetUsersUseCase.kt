package id.vincenttp.tikettest.domain.usecase

import id.vincenttp.tikettest.domain.base.BaseUseCase
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.repository.UserRepository

/**
 * Created by vincenttp on 13/07/20.
 */
class GetUsersUseCase(val repository: UserRepository) : BaseUseCase<List<UserEntity>>() {
    override suspend fun build(): List<UserEntity> = repository.getUser()

}