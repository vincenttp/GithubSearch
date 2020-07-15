package id.vincenttp.tikettest.data.response

import com.google.gson.annotations.SerializedName

/**
 * Created by vincenttp on 13/07/20.
 */

data class SearchResponse(
    @SerializedName("items") val items: List<UserResponse>
)

data class UserResponse(
    @SerializedName("login") val name: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("avatar_url") val avatar_url: String?
)