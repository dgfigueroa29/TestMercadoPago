package com.boa.testmercadopago.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

/**
 * Base ViewModel for using in Model-View-ViewModel architecture. Must be specified ViewState class.
 */
abstract class BaseViewModel<V> : ViewModel() {
    val resourceViewState: MediatorLiveData<V> =
        MediatorLiveData<V>().apply { postValue(getInitialViewState()) }

    abstract fun getInitialViewState(): V
    abstract fun initialize()
}