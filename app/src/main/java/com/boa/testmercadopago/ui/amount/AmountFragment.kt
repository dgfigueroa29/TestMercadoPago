package com.boa.testmercadopago.ui.amount

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.base.BaseViewState
import kotlinx.android.synthetic.main.amount_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AmountFragment : BaseFragment<BaseViewState, AmountViewModel>() {
    override fun initViewModel(): AmountViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.amount_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.amount_title)
        amountFragmentButton.setOnClickListener {
            if (amountFragmentInput.cleanIntValue > 0) {
                amountFragmentInput.error = null
                requireActivity().findNavController(R.id.amountFragmentRoot)
                    .navigate(R.id.navigation_action_amount_to_payment)
            } else {
                amountFragmentInput.error = getString(R.string.input_error)
            }
        }
    }

    override fun onViewStateUpdated(viewState: BaseViewState) {
    }
}