package id.vincenttp.tikettest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.vincenttp.tikettest.domain.base.Result
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.usecase.GetUsersUseCase

/**
 * Created by vincenttp on 15/07/20.
 */
class MainViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _users = MutableLiveData<Result<List<UserEntity>>>()
    val user: LiveData<Result<List<UserEntity>>> = _users

    suspend fun getUsers() {
        getUsersUseCase.invoke().run(_users::postValue)
    }
}