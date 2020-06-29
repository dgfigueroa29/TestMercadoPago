package com.boa.testmercadopago.ui.amount

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.util.ARGUMENT_AMOUNT
import com.boa.testmercadopago.util.hideKeyboard
import kotlinx.android.synthetic.main.amount_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AmountFragment : BaseFragment<AmountViewState, AmountViewModel>() {
    override fun initViewModel(): AmountViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.amount_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.amount_title)
        amountFragmentInput.setDelimiter(false)
        amountFragmentInput.setDecimals(false)
        amountFragmentInput.setSpacing(true)
        amountFragmentInput.setSeparator(".")
        amountFragmentButton.setOnClickListener {
            when {
                amountFragmentInput.text.isNullOrEmpty() -> {
                    amountFragmentInput.error = getString(R.string.input_error)
                }

                amountFragmentInput.cleanIntValue <= 0 -> {
                    amountFragmentInput.error = getString(R.string.input_error)
                }

                else -> {
                    amountFragmentInput.hideKeyboard()
                    amountFragmentInput.error = null
                    requireActivity().findNavController(R.id.amountFragmentRoot)
                        .navigate(
                            R.id.navigation_action_amount_to_payment,
                            bundleOf(ARGUMENT_AMOUNT to "$amountFragmentInput.cleanIntValue")
                        )
                }
            }
        }
    }

    override fun onViewStateUpdated(viewState: AmountViewState) {
    }
}