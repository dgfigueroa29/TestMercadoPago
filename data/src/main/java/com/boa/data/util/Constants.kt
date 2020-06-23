package com.boa.data.util

const val BASE_URL = "https://api.mercadopago.com/v1/payment_methods"
const val PAYMENT_METHOD = "?public_key=TEST-44c02012-9e6e-41d5-833e-e515822a2342"
const val CARD_ISSUERS = "/card_issuers${PAYMENT_METHOD}&payment_method_id="
const val INSTALLMENTS = "/installments${PAYMENT_METHOD}&payment_method_id="