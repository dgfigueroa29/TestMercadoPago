package com.boa.testmercadopago.base

/**
 * Base interface for item selection featured in lists and recycler views.
 */
interface OnSelectItem<T> {
    fun onSelectItem(item: T)
}