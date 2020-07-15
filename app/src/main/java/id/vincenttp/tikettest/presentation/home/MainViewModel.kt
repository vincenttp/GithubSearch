package id.vincenttp.tikettest.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.vincenttp.tikettest.data.paging.PostsDataSource
import id.vincenttp.tikettest.domain.entity.UserEntity
import id.vincenttp.tikettest.domain.repository.UserRepository

/**
 * Created by vincenttp on 15/07/20.
 */
class MainViewModel(val repository: UserRepository) : ViewModel() {
    var users: LiveData<PagedList<UserEntity>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
        users = initializedPagedListBuilder(config).build()
    }

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<Int, UserEntity> {

        val dataSourceFactory = object : DataSource.Factory<Int, UserEntity>() {
            override fun create(): DataSource<Int, UserEntity> {
                return PostsDataSource(repository)
            }
        }
        return LivePagedListBuilder(dataSourceFactory, config)
    }
}