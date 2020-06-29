package com.boa.data.datasource.remote

import com.boa.data.datasource.InstallmentDataSource
import com.boa.data.datasource.remote.response.InstallmentResponse
import com.boa.data.util.INSTALLMENTS

class RemoteInstallmentDataSource(private val appApi: AppApi) : InstallmentDataSource {
    override suspend fun getInstallment(
        paymentMethodId: String,
        issuerId: String,
        amount: Float
    ): List<InstallmentResponse> =
        appApi.getInstallments("$INSTALLMENTS${paymentMethodId}&amount=$amount&issuer.id=$issuerId")
}