package com.boa.data.datasource.remote

import com.boa.data.datasource.CardIssuerDataSource
import com.boa.data.datasource.remote.response.CardIssuerResponse
import com.boa.data.util.CARD_ISSUERS

class RemoteCardIssuerDataSource(private val appApi: AppApi) : CardIssuerDataSource {
    override suspend fun getCardIssuer(paymentMethodId: String): List<CardIssuerResponse> =
        appApi.getCardIssuers(
            "$CARD_ISSUERS$paymentMethodId"
        )
}