package com.boa.testmercadopago.ui.installment

import android.os.Bundle
import android.view.View
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.base.BaseViewState
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class InstallmentFragment : BaseFragment<BaseViewState, InstallmentViewModel>() {
    override fun initViewModel(): InstallmentViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.installment_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.installment_title)
    }

    override fun onViewStateUpdated(viewState: BaseViewState) {
    }
}