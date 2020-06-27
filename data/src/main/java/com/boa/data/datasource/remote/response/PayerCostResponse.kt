package com.boa.data.datasource.remote.response

data class PayerCostResponse(
    var installments: Int = 1,
    var recommended_message: String = "",
    var installment_amount: Float = 0F,
    var total_amount: Float = 0F
)