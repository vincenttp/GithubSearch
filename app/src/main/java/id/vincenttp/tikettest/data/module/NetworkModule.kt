package id.vincenttp.tikettest.data.module

import id.vincenttp.tikettest.data.base.ApiInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vincenttp on 15/07/20.
 */

val networkModule = module {
    factory {
        OkHttpClient.Builder().apply {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(logInterceptor)
        }
    }

    single {
        val okhttp = get<OkHttpClient.Builder>()
            .addInterceptor(ApiInterceptor())
            .build()
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttp)
    }
}