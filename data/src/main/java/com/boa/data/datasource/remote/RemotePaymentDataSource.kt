package com.boa.data.datasource.remote

import com.boa.data.datasource.PaymentDataSource
import com.boa.data.datasource.remote.response.PaymentResponse
import com.boa.data.util.PAYMENT_METHOD

class RemotePaymentDataSource(private val appApi: AppApi) : PaymentDataSource {
    override suspend fun getPaymentMethods(): List<PaymentResponse> = appApi.getPaymentMethods(
        PAYMENT_METHOD
    )
}