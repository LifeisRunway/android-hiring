package com.example.myapplication.utils

import androidx.annotation.IntRange
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import org.jetbrains.annotations.Range

fun Modifier.clickableNoRipple(onClick: () -> Unit): Modifier = composed {
    this
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            onClick()
        }
}


fun @receiver:IntRange(from = -1, to = 1) Int.asBoolean() : Boolean? = when(this) {
    -1 -> null
    0 -> false
    1 -> true
    else -> null
}

fun Boolean?.asInt() = when(this) {
    null -> -1
    false -> 0
    true -> 1
}