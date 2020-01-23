package com.mercadolibre.android.andesui.message.state

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.message.hierarchy.AndesMessageHierarchyInterface

internal fun getConfiguredBackgroundState(color: AndesMessageHierarchyInterface, state: AndesMessageStateInterface, context: Context): Drawable {
    val cornerRadius = context.resources.getDimension(R.dimen.andesui_button_border_radius_large)
    val contentOuterRadii = floatArrayOf(cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius)
    val buttonShape = ShapeDrawable(RoundRectShape(contentOuterRadii, null, null))
    buttonShape.paint.color = color.backgroundColor(context, state)

    return buttonShape


    //TODO Unused
}