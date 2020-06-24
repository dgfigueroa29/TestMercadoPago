package com.boa.testmercadopago.ui.payment

import android.os.Bundle
import android.view.View
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.base.BaseViewState
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PaymentFragment : BaseFragment<BaseViewState, PaymentViewModel>() {
    override fun initViewModel(): PaymentViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.payment_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.payment_title)
    }

    override fun onViewStateUpdated(viewState: BaseViewState) {
    }
}