package id.vincenttp.tikettest.data.module

import id.vincenttp.tikettest.data.repository.UserRepositoryImpl
import id.vincenttp.tikettest.domain.repository.UserRepository
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy

/**
 * Created by vincenttp on 15/07/20.
 */

val repositoryModule = module {
    factoryBy<UserRepository, UserRepositoryImpl>()
}