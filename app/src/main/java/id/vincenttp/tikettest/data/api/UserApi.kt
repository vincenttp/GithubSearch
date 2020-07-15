package id.vincenttp.tikettest.data.api

import id.vincenttp.tikettest.data.response.UserResponse
import retrofit2.http.GET

/**
 * Created by vincenttp on 13/07/20.
 */

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}