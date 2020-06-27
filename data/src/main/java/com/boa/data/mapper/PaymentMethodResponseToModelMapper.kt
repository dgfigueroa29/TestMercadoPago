package com.boa.data.mapper

import com.boa.data.datasource.remote.response.PaymentResponse
import com.boa.domain.base.BaseMapper
import com.boa.domain.model.PaymentMethod

class PaymentMethodResponseToModelMapper : BaseMapper<PaymentResponse, PaymentMethod>() {
    override fun map(input: PaymentResponse): PaymentMethod = PaymentMethod(
        input.id,
        input.name,
        input.payment_type_id,
        input.secure_thumbnail
    )
}