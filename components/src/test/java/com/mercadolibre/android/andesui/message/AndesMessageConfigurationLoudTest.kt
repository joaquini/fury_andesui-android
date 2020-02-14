package com.mercadolibre.android.andesui.message;

import android.os.Build
import com.mercadolibre.android.andesui.BuildConfig
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.button.hierarchy.BackgroundColorConfig
import com.mercadolibre.android.andesui.color.toAndesColor
import com.mercadolibre.android.andesui.message.factory.AndesMessageAttrs
import com.mercadolibre.android.andesui.message.factory.AndesMessageConfigurationFactory
import com.mercadolibre.android.andesui.message.hierarchy.AndesMessageHierarchy
import com.mercadolibre.android.andesui.message.type.AndesMessageType
import com.mercadolibre.android.andesui.typeface.getFontOrDefault
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.spy
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [Build.VERSION_CODES.LOLLIPOP])
class AndesMessageConfigurationLoudTest {

    private var context = RuntimeEnvironment.application

    private lateinit var andesMessage: AndesMessage
    private val configFactory = spy(AndesMessageConfigurationFactory)
    private lateinit var attrs: AndesMessageAttrs

    @Test
    fun `Loud, Neutral background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.backgroundColor, R.color.andesui_message_highlight_primary.toAndesColor())
    }

    @Test
    fun `Loud, Success background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.backgroundColor, R.color.andesui_message_success_primary.toAndesColor())
    }

    @Test
    fun `Loud, Error background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.backgroundColor, R.color.andesui_message_error_primary.toAndesColor())
    }

    @Test
    fun `Loud, Warning background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.backgroundColor, R.color.andesui_message_warning_primary.toAndesColor())
    }

    @Test
    fun `Loud, Neutral icon background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.iconBackgroundColor, R.color.andesui_message_highlight_primary_dark.toAndesColor())
    }

    @Test
    fun `Loud, Success icon background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.iconBackgroundColor, R.color.andesui_message_success_primary_dark.toAndesColor())
    }

    @Test
    fun `Loud, Error icon background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.iconBackgroundColor, R.color.andesui_message_error_primary_dark.toAndesColor())
    }

    @Test
    fun `Loud, Warning icon background color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.iconBackgroundColor, R.color.andesui_message_warning_primary_dark.toAndesColor())
    }

    @Test
    fun `Loud, Neutral pipe color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.pipeColor, R.color.andesui_message_highlight_primary.toAndesColor())
    }

    @Test
    fun `Loud, Success pipe color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.pipeColor, R.color.andesui_message_success_primary.toAndesColor())
    }

    @Test
    fun `Loud, Error pipe color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.pipeColor, R.color.andesui_message_error_primary.toAndesColor())
    }

    @Test
    fun `Loud, Warning pipe color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.pipeColor, R.color.andesui_message_warning_primary.toAndesColor())
    }

    @Test
    fun `Loud, Neutral text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.textColor, R.color.andesui_message_loud_text.toAndesColor())
    }

    @Test
    fun `Loud, Success text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.textColor, R.color.andesui_message_loud_text.toAndesColor())
    }

    @Test
    fun `Loud, Error text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.textColor, R.color.andesui_message_loud_text.toAndesColor())
    }

    @Test
    fun `Loud, Warning text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.textColor, R.color.andesui_message_loud_text.toAndesColor())
    }

    @Test
    fun `Loud, Neutral title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, "Title")
    }

    @Test
    fun `Loud, Success title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, "Title")
    }

    @Test
    fun `Loud, Error title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, "Title")
    }

    @Test
    fun `Loud, Warning title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, "Title")
    }

    @Test
    fun `Loud, Neutral body text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyText, "Body")
    }

    @Test
    fun `Loud, Success body text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyText, "Body")
    }

    @Test
    fun `Loud, Error body text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyText, "Body")
    }

    @Test
    fun `Loud, Warning body text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyText, "Body")
    }

    @Test
    fun `Loud, Neutral null title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", null, true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, null)
    }

    @Test
    fun `Loud, Success null title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", null, true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, null)
    }

    @Test
    fun `Loud, Error null title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", null, true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, null)
    }

    @Test
    fun `Loud, Warning null title text`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", null, true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleText, null)
    }

    @Test
    fun `Loud, Neutral title size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleSize, context.resources.getDimension(R.dimen.andesui_message_title))
    }

    @Test
    fun `Loud, Success title size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleSize, context.resources.getDimension(R.dimen.andesui_message_title))
    }

    @Test
    fun `Loud, Error title size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleSize, context.resources.getDimension(R.dimen.andesui_message_title))
    }

    @Test
    fun `Loud, Warning title size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleSize, context.resources.getDimension(R.dimen.andesui_message_title))
    }

    @Test
    fun `Loud, Neutral body size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodySize, context.resources.getDimension(R.dimen.andesui_message_body))
    }

    @Test
    fun `Loud, Success body size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodySize, context.resources.getDimension(R.dimen.andesui_message_body))
    }

    @Test
    fun `Loud, Error body size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodySize, context.resources.getDimension(R.dimen.andesui_message_body))
    }

    @Test
    fun `Loud, Warning body size`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodySize, context.resources.getDimension(R.dimen.andesui_message_body))
    }

    @Test
    fun `Loud, Neutral title typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleTypeface, context.getFontOrDefault(R.font.andesui_font_semibold))
    }

    @Test
    fun `Loud, Success title typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleTypeface, context.getFontOrDefault(R.font.andesui_font_semibold))
    }

    @Test
    fun `Loud, Error title typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleTypeface, context.getFontOrDefault(R.font.andesui_font_semibold))
    }

    @Test
    fun `Loud, Warning title typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.titleTypeface, context.getFontOrDefault(R.font.andesui_font_semibold))
    }

    @Test
    fun `Loud, Neutral body typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyTypeface, context.getFontOrDefault(R.font.andesui_font_regular))
    }

    @Test
    fun `Loud, Success body typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyTypeface, context.getFontOrDefault(R.font.andesui_font_regular))
    }

    @Test
    fun `Loud, Error body typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyTypeface, context.getFontOrDefault(R.font.andesui_font_regular))
    }

    @Test
    fun `Loud, Warning body typeface`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.bodyTypeface, context.getFontOrDefault(R.font.andesui_font_regular))
    }

    @Test
    fun `Loud, Neutral primary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_message_highlight_primary_dark.toAndesColor()
        assertEquals(config.primaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                andesColor,
                andesColor,
                andesColor))
    }

    @Test
    fun `Loud, Success primary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_message_success_primary_dark.toAndesColor()
        assertEquals(config.primaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                andesColor,
                andesColor,
                andesColor))
    }

    @Test
    fun `Loud, Error primary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_message_error_primary_dark.toAndesColor()
        assertEquals(config.primaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                andesColor,
                andesColor,
                andesColor))
    }

    @Test
    fun `Loud, Warning primary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_message_warning_primary_dark.toAndesColor()
        assertEquals(config.primaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                andesColor,
                andesColor,
                andesColor))
    }

    @Test
    fun `Loud, Neutral secondary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_bu_transparent_idle.toAndesColor()
        val unusedAndesColor = R.color.andesui_message_highlight_primary.toAndesColor()
        assertEquals(config.secondaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                unusedAndesColor,
                unusedAndesColor,
                unusedAndesColor))
    }

    @Test
    fun `Loud, Success secondary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_bu_transparent_idle.toAndesColor()
        val unusedAndesColor = R.color.andesui_message_success_primary.toAndesColor()
        assertEquals(config.secondaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                unusedAndesColor,
                unusedAndesColor,
                unusedAndesColor))
    }

    @Test
    fun `Loud, Error secondary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_bu_transparent_idle.toAndesColor()
        val unusedAndesColor = R.color.andesui_message_error_primary.toAndesColor()
        assertEquals(config.secondaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                unusedAndesColor,
                unusedAndesColor,
                unusedAndesColor))
    }

    @Test
    fun `Loud, Warning secondary action color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        val andesColor = R.color.andesui_bu_transparent_idle.toAndesColor()
        val unusedAndesColor = R.color.andesui_message_warning_primary.toAndesColor()
        assertEquals(config.secondaryActionBackgroundColor, BackgroundColorConfig(
                andesColor,
                andesColor.copy(alpha = 0.15f),
                andesColor.copy(alpha = 0.07F),
                unusedAndesColor,
                unusedAndesColor,
                unusedAndesColor))
    }

    @Test
    fun `Loud, Neutral primary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.primaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Success primary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.primaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Error primary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.primaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Warning primary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.primaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Neutral secondary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.NEUTRAL, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.secondaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Success secondary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.SUCCESS, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.secondaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Error secondary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.ERROR, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.secondaryActionTextColor, R.color.andesui_white.toAndesColor())
    }

    @Test
    fun `Loud, Warning secondary action text color`() {
        attrs = AndesMessageAttrs(AndesMessageHierarchy.LOUD, AndesMessageType.WARNING, "Body", "Title", true)
        val config = configFactory.create(context, attrs)
        assertEquals(config.secondaryActionTextColor, R.color.andesui_white.toAndesColor())
    }
}