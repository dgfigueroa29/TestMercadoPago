package com.boa.domain.usecase

import com.boa.domain.base.BaseUseCase
import com.boa.domain.model.Installment
import com.boa.domain.repository.InstallmentRepository
import kotlinx.coroutines.CoroutineScope

class GetInstallmentsUseCase(
    scope: CoroutineScope,
    private val installmentRepository: InstallmentRepository
) : BaseUseCase<List<Installment>, GetInstallmentsUseCase.Params>(scope) {
    override suspend fun getData(param: Params): List<Installment> =
        installmentRepository.getInstallment(param.paymentMethodId, param.issuerId, param.amount)

    data class Params(
        val paymentMethodId: String, val issuerId: String,
        val amount: Float
    )
}