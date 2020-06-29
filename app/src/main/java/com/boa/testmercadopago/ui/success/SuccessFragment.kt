package com.boa.testmercadopago.ui.success

import android.os.Bundle
import android.view.View
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SuccessFragment : BaseFragment<SuccessViewState, SuccessViewModel>() {
    override fun initViewModel(): SuccessViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.success_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.success_title)
    }

    override fun onViewStateUpdated(viewState: SuccessViewState) {
    }
}