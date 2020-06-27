package com.boa.data.datasource.remote

import com.boa.data.datasource.CardIssuerDataSource
import com.boa.data.datasource.remote.response.CardIssuerResponse
import com.boa.data.util.CARD_ISSUERS

class RemoteCardIssuerDataSource(private val api: Api) : CardIssuerDataSource {
    override suspend fun getCardIssuer(paymentMethodId: String): List<CardIssuerResponse> =
        api.getCardIssuers(
            "$CARD_ISSUERS$paymentMethodId"
        )
}