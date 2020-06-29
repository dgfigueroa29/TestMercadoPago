package com.boa.testmercadopago.ui.installment

import com.boa.domain.base.BaseException
import com.boa.domain.base.BaseStatusObserver
import com.boa.domain.model.Installment
import com.boa.domain.usecase.GetInstallmentsUseCase
import com.boa.testmercadopago.base.BaseViewModel

class InstallmentViewModel(private val getInstallmentsUseCase: GetInstallmentsUseCase) :
    BaseViewModel<InstallmentViewState>() {
    private var resultList: List<Installment> = listOf()
    private var paymentMethodId: String = "visa"
    private var issuerId: String = "288"
    private var amount: Float = 1000F
    override fun getInitialViewState(): InstallmentViewState = InstallmentViewState()

    override fun initialize() {
        val bankViewState = getInitialViewState()
        BaseStatusObserver(
            resourceViewState,
            getInstallmentsUseCase.execute(
                GetInstallmentsUseCase.Params(
                    paymentMethodId,
                    issuerId,
                    amount
                )
            ),
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