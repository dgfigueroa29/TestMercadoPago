package com.boa.data.datasource

import com.boa.data.datasource.remote.response.CardIssuerResponse

interface CardIssuerDataSource {
    suspend fun getCardIssuer(paymentMethodId: String): List<CardIssuerResponse>
}