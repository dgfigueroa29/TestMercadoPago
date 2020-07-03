package com.boa.testmercadopago.ui.installment

import com.boa.domain.model.Installment
import com.boa.testmercadopago.base.BaseViewState

class InstallmentViewState(var resultList: List<Installment> = listOf()) : BaseViewState()