package com.boa.testmercadopago.ui.main

import com.boa.testmercadopago.base.BaseViewModel
import com.boa.testmercadopago.base.BaseViewState

class MainViewModel : BaseViewModel<BaseViewState>() {
    override fun getInitialViewState(): BaseViewState = BaseViewState()

    override fun initialize() {
    }
}