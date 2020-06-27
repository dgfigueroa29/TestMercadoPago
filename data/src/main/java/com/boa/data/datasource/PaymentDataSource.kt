package com.boa.data.datasource

import com.boa.data.datasource.remote.response.PaymentResponse

interface PaymentDataSource {
    suspend fun getPaymentMethods(): List<PaymentResponse>
}