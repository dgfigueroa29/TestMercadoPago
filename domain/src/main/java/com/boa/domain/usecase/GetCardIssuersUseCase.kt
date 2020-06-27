package com.boa.domain.usecase

import com.boa.domain.base.BaseUseCase
import com.boa.domain.model.CardIssuer
import com.boa.domain.repository.CardIssuerRepository
import kotlinx.coroutines.CoroutineScope

class GetCardIssuersUseCase(
    scope: CoroutineScope,
    private val cardIssuerRepository: CardIssuerRepository
) : BaseUseCase<List<CardIssuer>, GetCardIssuersUseCase.Params>(scope) {
    override suspend fun getData(param: Params): List<CardIssuer> =
        cardIssuerRepository.getCardIssuersList(param.paymentMethodId)

    data class Params(val paymentMethodId: String)
}