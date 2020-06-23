package com.boa.domain.util

import java.util.*

fun String?.containsSomething(value: String = ""): Boolean = if (this != null) {
    if (value.isNotEmpty()) {
        this.toLowerCase(Locale.getDefault())
            .trim() != "null" && this.toLowerCase(Locale.getDefault())
            .trim().isNotEmpty() && this.contains(value)
    } else {
        this.toLowerCase(Locale.getDefault())
            .trim() != "null" && this.toLowerCase(Locale.getDefault())
            .trim().isNotEmpty()
    }
} else {
    false
}