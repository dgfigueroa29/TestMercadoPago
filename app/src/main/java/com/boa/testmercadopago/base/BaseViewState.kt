package com.boa.testmercadopago.base

/**
 * Base ViewState for using in Model-View-ViewModel architecture. Must contain all of the data necessary for the view to draw itself at the current state.
 */
open class BaseViewState {
    var isReady = false
    var hasError = false
    var hasSuccess = false
    var isComplete = false
    var yetLoading = false
}