package com.boa.testmercadopago.ui.bank

import com.boa.domain.base.BaseException
import com.boa.domain.base.BaseStatusObserver
import com.boa.domain.model.CardIssuer
import com.boa.domain.usecase.GetCardIssuersUseCase
import com.boa.testmercadopago.base.BaseViewModel

class BankViewModel(private val getCardIssuersUseCase: GetCardIssuersUseCase) :
    BaseViewModel<BankViewState>() {
    private var resultList: List<CardIssuer> = listOf()
    private var paymentMethodId: String = "visa"
    override fun getInitialViewState(): BankViewState = BankViewState()

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