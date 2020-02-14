package com.mercadolibre.android.andesui.button.hierarchy

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.StateListDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.button.AndesButton
import com.mercadolibre.android.andesui.color.AndesColor
import com.mercadolibre.android.andesui.color.toAndesColor

/**
 * Useful class that holds all the possible colors for the [AndesButton] background.
 *
 * @property enabledColor
 * @property pressedColor
 * @property focusedColor
 * @property hoveredColor
 * @property disabledColor
 * @property otherColor
 */
internal data class BackgroundColorConfig(
        val enabledColor: AndesColor,
        val pressedColor: AndesColor,
        val focusedColor: AndesColor,
        val hoveredColor: AndesColor,
        val disabledColor: AndesColor,
        val otherColor: AndesColor?
)

/**
 * Returns a [Drawable] ready to be used as the background of an [AndesButton]. Output is based on the received [colorConfig].
 *
 * @param context needed for accessing some resources.
 * @param cornerRadius radius of the button corner. This is needed because it depends on the button size.
 * @param colorConfig config that contains the specification of each required color.
 * @return
 */
internal fun getConfiguredBackground(context: Context, cornerRadius: Float, colorConfig: BackgroundColorConfig): Drawable {
    val buttonShape = RoundRectShape(getOuterRadii(cornerRadius), null, null)
    return StateListDrawable().apply {
        addState(intArrayOf(android.R.attr.state_pressed), createShapeDrawable(context, buttonShape, colorConfig.pressedColor))
        addState(intArrayOf(android.R.attr.state_enabled), createShapeDrawable(context, buttonShape, colorConfig.enabledColor))
        addState(intArrayOf(-android.R.attr.state_enabled), createShapeDrawable(context, buttonShape, colorConfig.disabledColor))
        addState(intArrayOf(android.R.attr.state_hovered), createShapeDrawable(context, buttonShape, colorConfig.hoveredColor))
        addState(intArrayOf(android.R.attr.state_focused), createShapeDrawable(context, buttonShape, colorConfig.focusedColor))
    }
}

private fun getOuterRadii(cornerRadius: Float) =
        floatArrayOf(cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius)

private fun createShapeDrawable(context: Context, shape: Shape, color: AndesColor) =
        ShapeDrawable(shape).apply { paint.color = color.colorInt(context) }

/**
 * Returns the proper [BackgroundColorConfig] for the Loud Hierarchy button.
 *
 */
internal fun createBackgroundColorConfigLoud() =
        BackgroundColorConfig(
                enabledColor = R.color.andesui_button_loud_bg.toAndesColor(),
                pressedColor = R.color.andesui_button_loud_bg_pressed.toAndesColor(),
                focusedColor = R.color.andesui_button_loud_bg_focused.toAndesColor(),
                hoveredColor = R.color.andesui_button_loud_bg_hovered.toAndesColor(),
                disabledColor = R.color.andesui_button_loud_bg_disabled.toAndesColor(),
                otherColor = R.color.andesui_button_loud_bg_other.toAndesColor())

/**
 * Returns the proper [BackgroundColorConfig] for the Quiet Hierarchy button.
 *
 */
internal fun createBackgroundColorConfigQuiet() =
        BackgroundColorConfig(
                enabledColor = R.color.andesui_button_quiet_bg.toAndesColor(),
                pressedColor = R.color.andesui_button_quiet_bg_pressed.toAndesColor(),
                focusedColor = R.color.andesui_button_quiet_bg_focused.toAndesColor(),
                hoveredColor = R.color.andesui_button_quiet_bg_hovered.toAndesColor(),
                disabledColor = R.color.andesui_button_quiet_bg_disabled.toAndesColor(),
                otherColor = R.color.andesui_button_quiet_bg_other.toAndesColor())

/**
 * Returns the proper [BackgroundColorConfig] for the Transparent Hierarchy button.
 *
 */
internal fun createBackgroundColorConfigTransparent() =
        BackgroundColorConfig(
                enabledColor = R.color.andesui_button_transparent_bg.toAndesColor(),
                pressedColor = R.color.andesui_button_transparent_bg_pressed.toAndesColor(),
                focusedColor = R.color.andesui_button_transparent_bg_focused.toAndesColor(),
                hoveredColor = R.color.andesui_button_transparent_bg_hovered.toAndesColor(),
                disabledColor = R.color.andesui_button_transparent_bg_disabled.toAndesColor(),
                otherColor = null)
