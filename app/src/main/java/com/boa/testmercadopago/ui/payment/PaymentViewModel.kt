package com.boa.testmercadopago.ui.payment

import com.boa.domain.base.BaseException
import com.boa.domain.base.BaseStatusObserver
import com.boa.domain.model.PaymentMethod
import com.boa.domain.usecase.GetPaymentMethodsUseCase
import com.boa.testmercadopago.base.BaseViewModel
import com.boa.testmercadopago.base.BaseViewState

class PaymentViewModel(private val getPaymentMethodsUseCase: GetPaymentMethodsUseCase) :
    BaseViewModel<BaseViewState>() {
    private var resultList: List<PaymentMethod> = listOf()
    override fun getInitialViewState(): BaseViewState = BaseViewState()

    override fun initialize() {
        val paymentViewState = getInitialViewState()
        BaseStatusObserver(resourceViewState, getPaymentMethodsUseCase.execute(null), {
            resultList = it ?: resultList
            paymentViewState.isReady = true
            //paymentViewState.resultList = resultList
            resourceViewState.value = paymentViewState
        }, this::onError, this::onLoading)
    }

    private fun onError(exception: BaseException?) {
    }

    private fun onLoading(progress: Int) {
    }
}