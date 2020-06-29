package com.boa.testmercadopago.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Fragment?.receiveSafeString(key: String): String = if (this?.requireArguments() != null) {
    try {
        if (this.requireArguments().containsKey(key)) {
            this.requireArguments().getString(key, "")
        } else {
            ""
        }
    } catch (e: Exception) {
        ""
    }
} else {
    ""
}