package com.boa.testmercadopago.ui.main

import com.boa.testmercadopago.base.BaseViewModel

class MainViewModel : BaseViewModel<MainViewState>() {
    override fun getInitialViewState(): MainViewState = MainViewState()

    override fun initialize() {
    }
}