package com.boa.data.datasource

import com.boa.data.datasource.remote.response.InstallmentResponse

interface InstallmentDataSource {
    suspend fun getInstallment(
        paymentMethodId: String,
        issuerId: String,
        amount: Float
    ): List<InstallmentResponse>
}