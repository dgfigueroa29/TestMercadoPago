package com.boa.domain.repository

import com.boa.domain.model.CardIssuer

interface CardIssuerRepository {
    suspend fun getCardIssuersList(paymentMethodId: String): List<CardIssuer>
}