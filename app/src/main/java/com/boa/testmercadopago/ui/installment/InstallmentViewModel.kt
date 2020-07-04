package com.boa.testmercadopago.ui.installment

import com.boa.domain.base.BaseException
import com.boa.domain.base.BaseStatusObserver
import com.boa.domain.model.Installment
import com.boa.domain.usecase.GetInstallmentsUseCase
import com.boa.testmercadopago.base.BaseViewModel

class InstallmentViewModel(private val getInstallmentsUseCase: GetInstallmentsUseCase) :
    BaseViewModel<InstallmentViewState>() {
    private var resultList: List<Installment> = listOf()
    var paymentMethodId: String = ""
    var cardIssuerId: String = ""
    var amount: Float = 0F
    override fun getInitialViewState(): InstallmentViewState = InstallmentViewState()

    override fun initialize() {
        val installmentViewState = getInitialViewState()
        BaseStatusObserver(
            resourceViewState,
            getInstallmentsUseCase.execute(
                GetInstallmentsUseCase.Params(
                    paymentMethodId,
                    cardIssuerId,
                    amount
                )
            ),
            {
                resultList = it ?: resultList
                installmentViewState.isReady = true
                installmentViewState.resultList = resultList
                resourceViewState.value = installmentViewState
            },
            this::onError,
            this::onLoading
        )
    }

    private fun onError(exception: BaseException?) {
        val viewStatus = getInitialViewState()
        viewStatus.isError = true
        viewStatus.errorMessage = exception?.message ?: ""
        resourceViewState.value = viewStatus
    }

    private fun onLoading(progress: Int) {
        val viewStatus = getInitialViewState()
        viewStatus.isLoading = progress > 100
        resourceViewState.value = viewStatus
    }
}