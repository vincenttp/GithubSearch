package id.vincenttp.tikettest.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.vincenttp.tikettest.data.paging.PagingDataSource
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.repository.UserRepository

/**
 * Created by vincenttp on 15/07/20.
 */
class MainViewModel(val repository: UserRepository) : ViewModel() {
    var keyword = MediatorLiveData<String>()
    var users: LiveData<PagedList<UserEntity>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
        users = Transformations.switchMap(keyword) {
            initializedPagedListBuilder(config, it).build()
        }
    }

    fun search(q: String) {
        keyword.postValue(q)
    }

    private fun initializedPagedListBuilder(config: PagedList.Config, q: String):
            LivePagedListBuilder<Int, UserEntity> {

        val dataSourceFactory = object : DataSource.Factory<Int, UserEntity>() {
            override fun create(): DataSource<Int, UserEntity> {
                return PagingDataSource(repository, q)
            }
        }
        return LivePagedListBuilder(dataSourceFactory, config)
    }
}