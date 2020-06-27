package com.boa.data.datasource.remote

import com.boa.data.datasource.remote.response.CardIssuerResponse
import com.boa.data.datasource.remote.response.InstallmentResponse
import com.boa.data.datasource.remote.response.PaymentResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    suspend fun getPaymentMethods(@Url url: String): List<PaymentResponse>

    @GET
    suspend fun getCardIssuers(@Url url: String): List<CardIssuerResponse>

    @GET
    suspend fun getInstallments(@Url url: String): List<InstallmentResponse>
}