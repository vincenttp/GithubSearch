package id.vincenttp.tikettest.domain.module

import id.vincenttp.tikettest.domain.usecase.GetUsersUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.factory

/**
 * Created by vincenttp on 15/07/20.
 */

val useCaseModule = module {
    factory<GetUsersUseCase>()
}