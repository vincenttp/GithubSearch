package id.vincenttp.tikettest.data

import retrofit2.http.GET

/**
 * Created by vincenttp on 13/07/20.
 */

interface UserApi {
    @GET("v1/me")
    suspend fun getUsers(): List<UserResponse>
}