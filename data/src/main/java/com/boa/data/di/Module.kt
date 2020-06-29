package com.boa.data.di

import com.boa.data.datasource.CardIssuerDataSource
import com.boa.data.datasource.InstallmentDataSource
import com.boa.data.datasource.PaymentDataSource
import com.boa.data.datasource.remote.ApiProvider
import com.boa.data.datasource.remote.RemoteCardIssuerDataSource
import com.boa.data.datasource.remote.RemoteInstallmentDataSource
import com.boa.data.datasource.remote.RemotePaymentDataSource
import com.boa.data.mapper.CardIssuerResponseToModelMapper
import com.boa.data.mapper.InstallmentResponseToModelMapper
import com.boa.data.mapper.PaymentMethodResponseToModelMapper
import com.boa.data.repository.CardIssuerRepositoryImpl
import com.boa.data.repository.InstallmentRepositoryImpl
import com.boa.data.repository.PaymentMethodRepositoryImpl
import com.boa.domain.repository.CardIssuerRepository
import com.boa.domain.repository.InstallmentRepository
import com.boa.domain.repository.PaymentMethodRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<PaymentDataSource> { RemotePaymentDataSource(get()) }
    single<CardIssuerDataSource> { RemoteCardIssuerDataSource(get()) }
    single<InstallmentDataSource> { RemoteInstallmentDataSource(get()) }

    single<PaymentMethodRepository> { PaymentMethodRepositoryImpl(get(), get()) }
    single<CardIssuerRepository> { CardIssuerRepositoryImpl(get(), get()) }
    single<InstallmentRepository> { InstallmentRepositoryImpl(get(), get()) }

    single { PaymentMethodResponseToModelMapper() }
    single { CardIssuerResponseToModelMapper() }
    single { InstallmentResponseToModelMapper() }

    single { ApiProvider(androidContext()) }
    single {
        val apiProvider: ApiProvider = get()
        apiProvider.api
    }
}