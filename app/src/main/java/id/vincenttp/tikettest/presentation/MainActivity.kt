package id.vincenttp.tikettest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import id.vincenttp.tikettest.R
import id.vincenttp.tikettest.domain.base.Result
import id.vincenttp.tikettest.domain.entity.UserEntity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            viewModel.getUsers()
        }

        observeUsers()
    }

    private fun observeUsers() {
        viewModel.user.observe(this, Observer {
            when (it) {
                is Result.Success<List<UserEntity>> -> {
                    println("observeUsers $it")
                }
                is Result.Error -> {
                    println("observeUsers ${it.exception}")
                }
            }
        })
    }
}