package com.boa.domain.di

import com.boa.domain.usecase.GetCardIssuersUseCase
import com.boa.domain.usecase.GetInstallmentsUseCase
import com.boa.domain.usecase.GetPaymentMethodsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory { GetPaymentMethodsUseCase(get(), get()) }
    factory { GetCardIssuersUseCase(get(), get()) }
    factory { GetInstallmentsUseCase(get(), get()) }

    single { CoroutineScope(Dispatchers.IO) }
}