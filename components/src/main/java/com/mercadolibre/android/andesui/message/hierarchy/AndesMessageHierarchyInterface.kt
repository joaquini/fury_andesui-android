package com.mercadolibre.android.andesui.message.hierarchy

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.button.hierarchy.BackgroundColorConfig
import com.mercadolibre.android.andesui.button.hierarchy.createBackgroundColorConfigLoud
import com.mercadolibre.android.andesui.button.hierarchy.createBackgroundColorConfigTransparent
import com.mercadolibre.android.andesui.color.AndesColor
import com.mercadolibre.android.andesui.color.toAndesColor
import com.mercadolibre.android.andesui.color.toAndesColorWithAlpha
import com.mercadolibre.android.andesui.message.AndesMessage
import com.mercadolibre.android.andesui.message.type.AndesMessageTypeInterface
import com.mercadolibre.android.andesui.typeface.getFontOrDefault
import com.mercadolibre.android.andesui.utils.buildColoredBitmapDrawable

/**
 * Defines all style related properties that an [AndesMessage] needs to be drawn properly.
 * Those properties change depending on the style of the message.
 *
 */
internal sealed class AndesMessageHierarchyInterface {
    /**
     * Returns a [Drawable] that contains the color data for the message background.
     * This includes color of the bg for normal, pressed, hover and focused states.
     *
     * @param context needed for accessing some resources.
     * @return a [Drawable] that contains the color data for the message background.
     */
    abstract fun backgroundColor(): AndesColor

    abstract fun backgroundColor(type: AndesMessageTypeInterface): AndesColor

    /**
     * Returns a [ColorStateList] that contains the data for the text color.
     * We are using [ColorStateList] because text color depends on the message type. E.g. text color for enabled type is different
     * than for the disabled type.
     *
     * @param context needed for accessing some resources.
     * @return a [ColorStateList] that contains the data for the text color.
     */
    abstract fun textColor(): AndesColor

    /**
     * Returns an [Int] representing a @ColorInt that will be used when tinting the icon.
     *
     * @param context needed for accessing some resources.
     * @return an [Int] representing a @ColorInt that will be used when tinting the icon.
     */
    abstract fun dismissableIconColor(): AndesColor

    /**
     * Returns the [Drawable] that will be used as the dismiss icon.
     *
     * @param hierarchy needed to obtain the color of the dismiss icon.
     * @param context needed for accessing some resources.
     */
    fun dismissableIcon(hierarchy: AndesMessageHierarchyInterface, context: Context) =
            buildColoredBitmapDrawable(
                    ContextCompat.getDrawable(context, R.drawable.andesui_ui_close_20) as BitmapDrawable,
                    context,
                    hierarchy.dismissableIconColor()
            )

    /**
     * Returns the [Typeface] that should be used for the title inside the [AndesMessage].
     *
     * @param context needed for accessing some resources. In this case, for accessing the kotlin extension defines for the context.
     * @return the [Typeface] that should be used for the text inside the [AndesMessage].
     */
    fun titleTypeface(context: Context): Typeface = context.getFontOrDefault(R.font.andesui_font_semibold)

    /**
     * Returns the [Typeface] that should be used for the text inside the [AndesMessage].
     *
     * @param context needed for accessing some resources. In this case, for accessing the kotlin extension defines for the context.
     * @return the [Typeface] that should be used for the text inside the [AndesMessage].
     */
    fun bodyTypeface(context: Context): Typeface = context.getFontOrDefault(R.font.andesui_font_regular)

    /**
     * Returns the background color that the icon will have. It's the color of the container in which the icon will live.
     *
     * @param context needed for accessing some resources.
     * @param type needed because the background color is intimately related to the type of the Message.
     * @return the background color that the icon will have.
     */

    abstract fun iconBackgroundColor(type: AndesMessageTypeInterface): AndesColor

    abstract fun primaryActionBackgroundColor(type: AndesMessageTypeInterface): BackgroundColorConfig

    fun primaryActionTextColor() = R.color.andesui_white.toAndesColor()

    abstract fun secondaryActionBackgroundColor(state: AndesMessageTypeInterface): BackgroundColorConfig

    abstract fun secondaryActionTextColor(type: AndesMessageTypeInterface): AndesColor
}

internal object AndesLoudMessageHierarchy : AndesMessageHierarchyInterface() {
    override fun backgroundColor() = throw IllegalStateException("Loud message cannot be colored without an AndesMessageType")
    override fun backgroundColor(type: AndesMessageTypeInterface) = type.primaryColor()
    override fun textColor() = R.color.andesui_message_loud_text.toAndesColor()
    override fun dismissableIconColor() = R.color.andesui_message_loud_dismissable.toAndesColor()
    override fun iconBackgroundColor(type: AndesMessageTypeInterface) = type.secondaryColor()
    override fun primaryActionBackgroundColor(type: AndesMessageTypeInterface): BackgroundColorConfig {
        val iconBackgroundColor = iconBackgroundColor(type)
        return BackgroundColorConfig(
                enabledColor = iconBackgroundColor,
                pressedColor = iconBackgroundColor.copy(alpha = 0.15f),
                focusedColor = iconBackgroundColor.copy(alpha = 0.07f),
                hoveredColor = iconBackgroundColor,
                disabledColor = iconBackgroundColor,
                otherColor = iconBackgroundColor)
    }

    override fun secondaryActionBackgroundColor(state: AndesMessageTypeInterface): BackgroundColorConfig {
        val backgroundColor = backgroundColor(state)
        return BackgroundColorConfig(
                enabledColor = R.color.andesui_bu_transparent_idle.toAndesColor(),
                pressedColor = R.color.andesui_bu_transparent_idle.toAndesColorWithAlpha(0.15f),
                focusedColor = R.color.andesui_bu_transparent_idle.toAndesColorWithAlpha(0.07f),
                hoveredColor = backgroundColor,
                disabledColor = backgroundColor,
                otherColor = backgroundColor)
    }

    override fun secondaryActionTextColor(type: AndesMessageTypeInterface) = R.color.andesui_white.toAndesColor()
}

internal object AndesQuietMessageHierarchy : AndesMessageHierarchyInterface() {
    override fun backgroundColor() = R.color.andesui_message_quiet_bg.toAndesColor()
    override fun backgroundColor(type: AndesMessageTypeInterface) = backgroundColor()
    override fun textColor() = R.color.andesui_message_quiet_text.toAndesColor()
    override fun dismissableIconColor() = R.color.andesui_message_quiet_dismissable.toAndesColor()
    override fun iconBackgroundColor(type: AndesMessageTypeInterface) = type.primaryColor()
    override fun primaryActionBackgroundColor(type: AndesMessageTypeInterface): BackgroundColorConfig {
        return createBackgroundColorConfigLoud()
    }

    override fun secondaryActionBackgroundColor(state: AndesMessageTypeInterface): BackgroundColorConfig {
        return createBackgroundColorConfigTransparent()
    }

    override fun secondaryActionTextColor(type: AndesMessageTypeInterface) = R.color.andesui_bu_transparent_text.toAndesColor()
}
