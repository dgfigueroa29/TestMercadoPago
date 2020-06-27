package com.boa.data.repository

import com.boa.data.datasource.PaymentDataSource
import com.boa.data.mapper.PaymentMethodResponseToModelMapper
import com.boa.domain.model.PaymentMethod
import com.boa.domain.repository.PaymentMethodRepository

class PaymentMethodRepositoryImpl(
    private val paymentDataSource: PaymentDataSource,
    private val paymentMethodResponseToModelMapper: PaymentMethodResponseToModelMapper
) : PaymentMethodRepository {
    override suspend fun getPaymentMethods(): List<PaymentMethod> =
        paymentMethodResponseToModelMapper.mapAll(paymentDataSource.getPaymentMethods())
}