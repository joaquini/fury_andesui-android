package com.mercadolibre.android.andesui.color

import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.graphics.ColorUtils

internal data class AndesColor(@ColorRes val colorRes: Int,
                               val alpha: Float = 1f) {
    @ColorInt
    fun colorInt(context: Context): Int =
            if (alpha == 1f) {
                colorRes.toColor(context)
            } else {
                ColorUtils.blendARGB(colorRes.toColor(context), Color.BLACK, alpha)
            }
}