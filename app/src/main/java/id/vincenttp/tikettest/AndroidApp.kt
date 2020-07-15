package id.vincenttp.tikettest

import android.app.Application
import id.vincenttp.tikettest.data.module.apiModule
import id.vincenttp.tikettest.data.module.networkModule
import id.vincenttp.tikettest.data.module.repositoryModule
import id.vincenttp.tikettest.domain.module.useCaseModule
import id.vincenttp.tikettest.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by vincenttp on 15/07/20.
 */
class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AndroidApp)
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}