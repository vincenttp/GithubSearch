package id.vincenttp.tikettest.data.base

import id.vincenttp.tikettest.data.response.UserResponse
import id.vincenttp.tikettest.domain.entity.UserEntity

/**
 * Created by vincenttp on 15/07/20.
 */

fun transform(value: UserResponse) =
    UserEntity(
        value.login.orEmpty(),
        value.id ?: 0,
        value.avatar_url.orEmpty()
    )