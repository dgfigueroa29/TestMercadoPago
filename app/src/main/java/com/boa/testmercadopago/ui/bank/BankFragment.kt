package com.boa.testmercadopago.ui.bank

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.transition.TransitionManager
import com.boa.domain.model.CardIssuer
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.base.OnSelectItem
import com.boa.testmercadopago.util.*
import com.boa.testmercadopago.view.Stagger
import kotlinx.android.synthetic.main.bank_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.ref.WeakReference

class BankFragment : BaseFragment<BankViewState, BankViewModel>(),
    OnSelectItem<CardIssuer> {
    private var amount: String = "0"
    private var paymentMethodId: String = ""
    private var adapter: ListAdapter<CardIssuer>? = null

    override fun initViewModel(): BankViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.bank_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amount = receiveSafeString(ARGUMENT_AMOUNT)
        paymentMethodId = receiveSafeString(ARGUMENT_PAYMENT)
        viewModel.paymentMethodId = paymentMethodId
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.bank_title)
        val contextRef = WeakReference(requireContext().applicationContext)
        bankFragmentList.build(contextRef)
        adapter = ListAdapter(contextRef, this)
        bankFragmentList.adapter = adapter
    }

    override fun onViewStateUpdated(viewState: BankViewState) {
        if (viewState.isReady) {
            TransitionManager.beginDelayedTransition(bankFragmentList, Stagger())
            adapter?.setData(viewState.resultList)
        }
    }

    override fun onSelectItem(item: CardIssuer) {
        requireActivity().findNavController(R.id.bankFragmentRoot)
            .navigate(
                R.id.navigation_action_bank_to_installment,
                bundleOf(
                    ARGUMENT_AMOUNT to amount,
                    ARGUMENT_PAYMENT to paymentMethodId,
                    ARGUMENT_BANK to item.id
                )
            )
    }
}