package com.boa.data.util

const val BASE_URL = "https://api.mercadopago.com/v1/"
const val PUBLIC_KEY = "?public_key=TEST-44c02012-9e6e-41d5-833e-e515822a2342"
const val PAYMENT_METHOD = "${BASE_URL}payment_methods${PUBLIC_KEY}"
const val CARD_ISSUERS = "${BASE_URL}card_issuers${PUBLIC_KEY}&payment_method_id="
const val INSTALLMENTS = "${BASE_URL}installments${PUBLIC_KEY}&payment_method_id="