package id.vincenttp.tikettest.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }

    private fun initView() {
        rvUser.adapter = adapter
    }

    private fun observeUsers() {
        viewModel.users.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}