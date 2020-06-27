package com.boa.domain.model

data class Installment(
    var id: Int = 1,
    var message: String = "",
    var amount: Float = 0F,
    var total: Float = 0F
)