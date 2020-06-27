package com.boa.data.mapper

import com.boa.data.datasource.remote.response.CardIssuerResponse
import com.boa.domain.base.BaseMapper
import com.boa.domain.model.CardIssuer

class CardIssuerResponseToModelMapper : BaseMapper<CardIssuerResponse, CardIssuer>() {
    override fun map(input: CardIssuerResponse): CardIssuer = CardIssuer(
        input.id,
        input.name,
        input.secure_thumbnail
    )
}