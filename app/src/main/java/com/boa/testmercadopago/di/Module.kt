package com.boa.testmercadopago.di

import com.boa.testmercadopago.ui.amount.AmountViewModel
import com.boa.testmercadopago.ui.bank.BankViewModel
import com.boa.testmercadopago.ui.installment.InstallmentViewModel
import com.boa.testmercadopago.ui.main.MainViewModel
import com.boa.testmercadopago.ui.payment.PaymentViewModel
import com.boa.testmercadopago.ui.success.SuccessViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AmountViewModel() }
    viewModel { BankViewModel() }
    viewModel { InstallmentViewModel() }
    viewModel { MainViewModel() }
    viewModel { PaymentViewModel() }
    viewModel { SuccessViewModel() }
}