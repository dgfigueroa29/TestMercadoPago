package com.boa.testmercadopago.ui.payment

import com.boa.testmercadopago.base.BaseViewModel
import com.boa.testmercadopago.base.BaseViewState

class PaymentViewModel : BaseViewModel<BaseViewState>() {
    override fun getInitialViewState(): BaseViewState = BaseViewState()

    override fun initialize() {
    }
}