package com.boa.testmercadopago.ui.bank

import com.boa.domain.base.BaseException
import com.boa.domain.base.BaseStatusObserver
import com.boa.domain.model.CardIssuer
import com.boa.domain.usecase.GetCardIssuersUseCase
import com.boa.testmercadopago.base.BaseViewModel
import com.boa.testmercadopago.base.BaseViewState

class BankViewModel(private val getCardIssuersUseCase: GetCardIssuersUseCase) :
    BaseViewModel<BaseViewState>() {
    private var resultList: List<CardIssuer> = listOf()
    private var paymentMethodId: String = "visa"
    override fun getInitialViewState(): BaseViewState = BaseViewState()

    override fun initialize() {
        val bankViewState = getInitialViewState()
        BaseStatusObserver(
            resourceViewState,
            getCardIssuersUseCase.execute(GetCardIssuersUseCase.Params(paymentMethodId)),
            {
                resultList = it ?: resultList
                bankViewState.isReady = true
                //paymentViewState.resultList = resultList
                resourceViewState.value = bankViewState
            },
            this::onError,
            this::onLoading
        )
    }

    private fun onError(exception: BaseException?) {
    }

    private fun onLoading(progress: Int) {
    }
}