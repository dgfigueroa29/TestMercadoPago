package com.boa.domain.repository

import com.boa.domain.model.PaymentMethod

interface PaymentMethodRepository {
    suspend fun getPaymentMethods(): List<PaymentMethod>
}