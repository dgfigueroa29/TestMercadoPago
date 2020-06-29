package com.boa.testmercadopago.ui.payment

import com.boa.domain.model.PaymentMethod
import com.boa.testmercadopago.base.BaseViewState

class PaymentViewState(var resultList: List<PaymentMethod> = listOf()) : BaseViewState()