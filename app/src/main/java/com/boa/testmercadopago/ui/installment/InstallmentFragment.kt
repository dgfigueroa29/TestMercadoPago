package com.boa.testmercadopago.ui.installment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.boa.domain.model.Installment
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.base.OnSelectItem
import com.boa.testmercadopago.util.*
import kotlinx.android.synthetic.main.installment_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.ref.WeakReference

class InstallmentFragment : BaseFragment<InstallmentViewState, InstallmentViewModel>(),
    OnSelectItem<Installment> {
    private var amount: String = "0"
    private var paymentMethodId: String = ""
    private var cardIssuerId: String = ""
    private var adapter: ListAdapter<Installment>? = null

    override fun initViewModel(): InstallmentViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.installment_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amount = receiveSafeString(ARGUMENT_AMOUNT)
        paymentMethodId = receiveSafeString(ARGUMENT_PAYMENT)
        cardIssuerId = receiveSafeString(ARGUMENT_BANK)
        viewModel.amount = amount.toFloat()
        viewModel.paymentMethodId = paymentMethodId
        viewModel.cardIssuerId = cardIssuerId
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.installment_title)
        val contextRef = WeakReference(requireContext().applicationContext)
        installmentFragmentList.build(contextRef)
        adapter = ListAdapter(contextRef, this)
        installmentFragmentList.adapter = adapter
    }

    override fun onViewStateUpdated(viewState: InstallmentViewState) {
        if (viewState.isReady) {
            adapter?.setData(viewState.resultList)
        }
    }

    override fun onSelectItem(item: Installment) {
        requireActivity().findNavController(R.id.installmentFragmentRoot)
            .navigate(
                R.id.navigation_action_installment_to_success,
                bundleOf(
                    ARGUMENT_AMOUNT to amount,
                    ARGUMENT_PAYMENT to paymentMethodId,
                    ARGUMENT_BANK to cardIssuerId,
                    ARGUMENT_INSTALLMENT to item.id
                )
            )
    }
}