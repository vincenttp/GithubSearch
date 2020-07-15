package id.vincenttp.tikettest.data.module

import id.vincenttp.tikettest.data.api.UserApi
import id.vincenttp.tikettest.data.base.Constant
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by vincenttp on 15/07/20.
 */

val apiModule = module {
    single {
        get<Retrofit.Builder>()
            .baseUrl(Constant.BASE_URL)
            .build()
            .create(UserApi::class.java)
    }
}