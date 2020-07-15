package id.vincenttp.tikettest.data.api

import id.vincenttp.tikettest.data.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by vincenttp on 13/07/20.
 */

interface UserApi {
    @GET("search/users")
    suspend fun getUsers(@Query("q") q: String, @Query("page") page: Int)
            : SearchResponse
}