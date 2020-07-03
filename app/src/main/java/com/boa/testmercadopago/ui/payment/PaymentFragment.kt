package com.boa.testmercadopago.ui.payment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.boa.domain.model.PaymentMethod
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.BaseFragment
import com.boa.testmercadopago.base.OnSelectItem
import com.boa.testmercadopago.util.*
import kotlinx.android.synthetic.main.payment_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.ref.WeakReference

class PaymentFragment : BaseFragment<PaymentViewState, PaymentViewModel>(),
    OnSelectItem<PaymentMethod> {
    private var amount: String = "0"
    private var adapter: ListAdapter<PaymentMethod>? = null

    override fun initViewModel(): PaymentViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.payment_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amount = receiveSafeString(ARGUMENT_AMOUNT)
        viewModel.initialize()
        toolbarTitle.text = getString(R.string.payment_title)
        val contextRef = WeakReference(requireContext().applicationContext)
        paymentFragmentList.build(contextRef)
        adapter = ListAdapter(contextRef, this)
        paymentFragmentList.adapter = adapter
    }

    override fun onViewStateUpdated(viewState: PaymentViewState) {
        if (viewState.isReady) {
            adapter?.setData(viewState.resultList)
        }
    }

    override fun onSelectItem(item: PaymentMethod) {
        requireActivity().findNavController(R.id.paymentFragmentRoot)
            .navigate(
                R.id.navigation_action_payment_to_bank,
                bundleOf(ARGUMENT_AMOUNT to amount, ARGUMENT_PAYMENT to item.id)
            )
    }
}