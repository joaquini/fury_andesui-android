package com.mercadolibre.android.andesui.button.factory

import android.graphics.drawable.Drawable
import com.mercadolibre.android.andesui.button.AndesButton

/**
 * Useful class that holds icon relative data that the [AndesButtonConfigurationFactory] will put
 * into [AndesButtonConfiguration] to determine the icon to put into the [AndesButton].
 *
 * TL;DR: Data of the icon to draw, if any, inside the button.
 *
 * @property leftIcon left icon of the button.
 * Has higher precedence than [rightIcon]: If both are defined then [leftIcon] will be used.
 * @property rightIcon right icon of the button.
 */
data class IconConfig(
        val leftIcon: Drawable?,
        val rightIcon: Drawable?,
        val iconPadding: Int = 0
)