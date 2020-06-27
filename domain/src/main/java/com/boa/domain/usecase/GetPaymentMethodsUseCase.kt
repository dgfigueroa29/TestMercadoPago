package com.boa.domain.usecase

import com.boa.domain.base.BaseUseCase
import com.boa.domain.model.PaymentMethod
import com.boa.domain.repository.PaymentMethodRepository
import kotlinx.coroutines.CoroutineScope

class GetPaymentMethodsUseCase(
    scope: CoroutineScope,
    private val paymentMethodRepository: PaymentMethodRepository
) : BaseUseCase<List<PaymentMethod>, Any?>(scope) {
    override suspend fun getData(param: Any?): List<PaymentMethod> =
        paymentMethodRepository.getPaymentMethods()
}