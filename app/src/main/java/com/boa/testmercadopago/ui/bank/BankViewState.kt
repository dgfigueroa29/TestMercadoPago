package com.boa.testmercadopago.ui.bank

import com.boa.domain.model.CardIssuer
import com.boa.testmercadopago.base.BaseViewState

class BankViewState(var resultList: List<CardIssuer> = listOf()) : BaseViewState()