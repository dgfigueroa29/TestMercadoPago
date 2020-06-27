package com.boa.domain.repository

import com.boa.domain.model.Installment

interface InstallmentRepository {
    suspend fun getInstallment(
        paymentMethodId: String,
        issuerId: String,
        amount: Float
    ): List<Installment>
}