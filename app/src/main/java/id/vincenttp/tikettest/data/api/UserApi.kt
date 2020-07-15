package id.vincenttp.tikettest.data.api

import id.vincenttp.tikettest.data.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by vincenttp on 13/07/20.
 */

interface UserApi {
    @GET("users")
    suspend fun getUsers(@Query("since") since: Int): List<UserResponse>
}