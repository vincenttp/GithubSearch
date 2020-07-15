package id.vincenttp.tikettest.data.base

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by vincenttp on 16/07/20.
 */
class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return original.newBuilder()
            .addHeader("Authorization", "token 802cc871c2ed0e8e97d955008586e49be0f2753d")
            .build()
            .let(chain::proceed)
    }
}