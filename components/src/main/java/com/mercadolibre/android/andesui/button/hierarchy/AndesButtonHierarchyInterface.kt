package com.mercadolibre.android.andesui.button.hierarchy

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.button.AndesButton
import com.mercadolibre.android.andesui.typeface.getFontOrDefault

/**
 * Defines all hierarchy related properties that an [AndesButton] needs to be drawn properly.
 * Those properties change depending on the hierarchy of the button.
 *
 */
internal sealed class AndesButtonHierarchyInterface {
    /**
     * Returns a [Drawable] that contains the color data for the button background.
     * This includes color of the bg for normal, pressed, hover and focused states.
     *
     * @param context needed for accessing some resources.
     * @param cornerRadius radius of the button corner. This is needed because it depends on the button size.
     * @return a [Drawable] that contains the color data for the button background.
     */
    abstract fun background(context: Context, cornerRadius: Float): Drawable

    /**
     * Returns a [ColorStateList] that contains the data for the text color.
     * We are using [ColorStateList] because text color depends on the button type. E.g. text color for enabled type is different
     * than for the disabled type.
     *
     * @param context needed for accessing some resources.
     * @return a [ColorStateList] that contains the data for the text color.
     */
    abstract fun textColor(context: Context): ColorStateList

    /**
     * Returns an [Int] representing a @ColorInt that will be used when tinting the icon.
     *
     * @param context needed for accessing some resources.
     * @return a [ColorStateList] that contains the data for the icon color.
     */
    fun iconColor(context: Context) = textColor(context)

    /**
     * Returns the [Typeface] that should be used for the text inside the [AndesButton].
     *
     * @param context needed for accessing some resources. In this case, for accessing the kotlin extension defines for the context.
     * @return the [Typeface] that should be used for the text inside the [AndesButton].
     */
    fun typeface(context: Context): Typeface = context.getFontOrDefault(R.font.andesui_font_semibold)
}

/**
 * Implementation of [AndesButtonHierarchyInterface] that returns the required data but personalized for the Loud Hierarchy,
 * according to Andes specifications.
 *
 */
internal object AndesLoudButtonHierarchy : AndesButtonHierarchyInterface() {
    override fun background(context: Context, cornerRadius: Float) = getConfiguredBackground(context, cornerRadius, createBackgroundColorConfigLoud())
    override fun textColor(context: Context) = getConfiguredTextColor(context, createTextColorConfigLoud())
}

/**
 * Implementation of [AndesButtonHierarchyInterface] that returns the required data but personalized for the Quiet Hierarchy,
 * according to Andes specifications.
 *
 */
internal object AndesQuietButtonHierarchy : AndesButtonHierarchyInterface() {
    override fun background(context: Context, cornerRadius: Float) = getConfiguredBackground(context, cornerRadius, createBackgroundColorConfigQuiet())
    override fun textColor(context: Context) = getConfiguredTextColor(context, createTextColorConfigQuiet())
}

/**
 * Implementation of [AndesButtonHierarchyInterface] that returns the required data but personalized for the Transparent Hierarchy,
 * according to Andes specifications.
 *
 */
internal object AndesTransparentButtonHierarchy : AndesButtonHierarchyInterface() {
    override fun background(context: Context, cornerRadius: Float) = getConfiguredBackground(context, cornerRadius, createBackgroundColorConfigTransparent())
    override fun textColor(context: Context) = getConfiguredTextColor(context, createTextColorConfigTransparent())
}