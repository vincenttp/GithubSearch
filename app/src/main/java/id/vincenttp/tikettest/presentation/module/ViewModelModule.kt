package id.vincenttp.tikettest.presentation.module

import id.vincenttp.tikettest.presentation.home.MainViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by vincenttp on 15/07/20.
 */

val viewModelModule = module {
    viewModel<MainViewModel>()
}