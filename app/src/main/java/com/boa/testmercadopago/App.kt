package com.boa.testmercadopago

import android.app.Application
import com.boa.data.di.dataModule
import com.boa.domain.di.domainModule
import com.boa.testmercadopago.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}