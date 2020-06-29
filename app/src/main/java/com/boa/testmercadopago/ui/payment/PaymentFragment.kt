package com.boa.testmercadopago.ui.payment

import android.os.Bundle
import android.view.View
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.util.ARGUMENT_AMOUNT
import com.boa.testmercadopago.util.receiveSafeString
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PaymentFragment : BaseFragment<PaymentViewState, PaymentViewModel>() {
    private var amount: String = "0"

    override fun initViewModel(): PaymentViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.payment_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amount = receiveSafeString(ARGUMENT_AMOUNT)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.payment_title)
    }

    override fun onViewStateUpdated(viewState: PaymentViewState) {
    }
}