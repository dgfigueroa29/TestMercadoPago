package com.boa.data.repository

import com.boa.data.datasource.CardIssuerDataSource
import com.boa.data.mapper.CardIssuerResponseToModelMapper
import com.boa.domain.model.CardIssuer
import com.boa.domain.repository.CardIssuerRepository

class CardIssuerRepositoryImpl(
    private val cardIssuerDataSource: CardIssuerDataSource,
    private val cardIssuerResponseToModelMapper: CardIssuerResponseToModelMapper
) : CardIssuerRepository {
    override suspend fun getCardIssuersList(paymentMethodId: String): List<CardIssuer> =
        cardIssuerResponseToModelMapper.mapAll(cardIssuerDataSource.getCardIssuer(paymentMethodId))
}