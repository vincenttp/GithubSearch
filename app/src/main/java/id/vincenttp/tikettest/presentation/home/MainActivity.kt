package id.vincenttp.tikettest.presentation.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import id.vincenttp.tikettest.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        observeUsers()
        observeError()
    }

    private fun initView() {
        rvUser.adapter = adapter
        etSearch.doAfterTextChanged {
            viewModel.search(it.toString())
        }
    }

    private fun observeUsers() {
        viewModel.users.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun observeError() {
        viewModel.error.observe(this, Observer {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
    }
}