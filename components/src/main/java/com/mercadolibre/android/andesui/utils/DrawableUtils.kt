package com.mercadolibre.android.andesui.utils

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.PorterDuff
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import com.mercadolibre.android.andesui.color.AndesColor

/**
 * Receives a [BitmapDrawable] which will suffer some look overhauling that includes scaling and tinting based on received params such as size, color, etc.
 * When the polishing ends, it will return a new [BitmapDrawable].
 * Size of the icon is based on Andes Specification.
 *
 * @param image image of the icon. Ok: The icon.
 * @param context needed for accessing some resources like size, you know.
 * @param dstWidth wanted width of the icon.
 * @param dstHeight wanted height of the icon.
 * @param colors we said we will be tinting the icon and this is the color. Note that the color for state_enabled will be used. If it does not exist, 0 will be used.
 * @return a complete look overhauled [BitmapDrawable].
 */
internal fun buildScaledColoredBitmapDrawable(image: BitmapDrawable, context: Context, dstWidth: Int, dstHeight: Int, colors: ColorStateList?): BitmapDrawable {
    val scaledBitmap = Bitmap.createScaledBitmap(
            image.bitmap,
            dstWidth,
            dstHeight,
            true)
    return BitmapDrawable(context.resources, scaledBitmap)
            .apply {
                colors?.let {
                    if (isLollipopOrNewer()) {
                        setTintMode(PorterDuff.Mode.SRC_IN)
                        setTintList(it)
                    } else {
                        setColorFilter(it.getColorForState(intArrayOf(android.R.attr.state_enabled), 0), PorterDuff.Mode.SRC_IN)
                    }
                }
            }
}

internal fun buildColoredBitmapDrawable(image: BitmapDrawable, context: Context, color: AndesColor? = null): BitmapDrawable {
    return BitmapDrawable(context.resources, image.bitmap)
            .apply {
                color?.let { setColorFilter(it.colorInt(context), PorterDuff.Mode.SRC_IN) }
            }
}

internal fun buildColoredCircularShapeWithIconDrawable(image: BitmapDrawable, context: Context, iconColor: AndesColor? = null, shapeColor: Int? = null, diameter: Int): Drawable {
    val icon = buildColoredBitmapDrawable(image, context, iconColor)

    val biggerCircle = ShapeDrawable(OvalShape())
    biggerCircle.intrinsicHeight = diameter
    biggerCircle.intrinsicWidth = diameter
    biggerCircle.paint.color = shapeColor!!
    biggerCircle.bounds = Rect(0, 0, diameter, diameter)

    return LayerDrawable(arrayOf(biggerCircle, icon))
}

private fun isLollipopOrNewer() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP