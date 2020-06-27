package com.boa.data.mapper

import com.boa.data.datasource.remote.response.PayerCostResponse
import com.boa.domain.base.BaseMapper
import com.boa.domain.model.Installment

class InstallmentResponseToModelMapper : BaseMapper<PayerCostResponse, Installment>() {
    override fun map(input: PayerCostResponse): Installment = Installment(
        input.installments,
        input.recommended_message,
        input.installment_amount,
        input.total_amount
    )
}