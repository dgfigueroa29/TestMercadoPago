package com.boa.testmercadopago.ui.main

import android.os.Bundle
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<MainViewState, MainViewModel>() {
    override fun initViewModel(): MainViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize()
    }

    override fun onViewStateUpdated(viewState: MainViewState) {
    }
}