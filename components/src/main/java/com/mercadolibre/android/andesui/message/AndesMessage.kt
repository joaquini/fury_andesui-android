package com.mercadolibre.android.andesui.message

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mercadolibre.android.andesui.BuildConfig
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.button.AndesButton
import com.mercadolibre.android.andesui.message.factory.AndesMessageAttrs
import com.mercadolibre.android.andesui.message.factory.AndesMessageAttrsParser
import com.mercadolibre.android.andesui.message.factory.AndesMessageConfiguration
import com.mercadolibre.android.andesui.message.factory.AndesMessageConfigurationFactory
import com.mercadolibre.android.andesui.message.hierarchy.AndesMessageHierarchy
import com.mercadolibre.android.andesui.message.type.AndesMessageType

class AndesMessage : CardView {

    /**
     * Getter and setter for [hierarchy].
     */
    var hierarchy: AndesMessageHierarchy
        get() = andesMessageAttrs.andesMessageHierarchy
        set(value) {
            andesMessageAttrs = andesMessageAttrs.copy(andesMessageHierarchy = value)
            setupColorComponents(createConfig())
        }
    /**
     * Getter and setter for [type].
     */
    var type: AndesMessageType
        get() = andesMessageAttrs.andesMessageType
        set(value) {
            andesMessageAttrs = andesMessageAttrs.copy(andesMessageType = value)
            setupColorComponents(createConfig())
        }

    /**
     * Getter and setter for [body].
     */
    var body: String
        get() = andesMessageAttrs.body
        set(value) {
            andesMessageAttrs = andesMessageAttrs.copy(body = value)
            setupBodyComponent(createConfig())
        }

    /**
     * Getter and setter for [title].
     */
    var title: String?
        get() = andesMessageAttrs.title
        set(value) {
            andesMessageAttrs = andesMessageAttrs.copy(title = value)
            setupTitleComponent(createConfig())
        }

    /**
     * Getter and setter for [isDismissable].
     */
    var isDismissable: Boolean
        get() = andesMessageAttrs.isDismissable
        set(value) {
            andesMessageAttrs = andesMessageAttrs.copy(isDismissable = value)
            setupDismissable(createConfig())
        }

    private var primaryActionText: String
        get() = primaryAction.textComponent.text.toString()
        set(value) {
            primaryAction.textComponent.text = value
        }

    private var secondaryActionText: String
        get() = secondaryAction.textComponent.text.toString()
        set(value) {
            secondaryAction.textComponent.text = value
        }

    private lateinit var messageContainer: ConstraintLayout
    private lateinit var titleComponent: TextView
    private lateinit var bodyComponent: TextView
    private lateinit var iconComponent: ImageView
    private lateinit var dismissableComponent: ImageView
    private lateinit var pipeComponent: View
    private lateinit var andesMessageAttrs: AndesMessageAttrs
    private lateinit var primaryAction: AndesButton
    private lateinit var secondaryAction: AndesButton


    @Suppress("unused")
    private constructor(context: Context) : super(context) {
        throw IllegalStateException("Constructor without parameters in Andes Message is not allowed. You must provide some attributes.")
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs) {
        initAttrs(attrs)
    }

    @Suppress("unused")
    constructor(context: Context,
                hierarchy: AndesMessageHierarchy = HIERARCHY_DEFAULT,
                type: AndesMessageType = STATE_DEFAULT,
                body: String,
                title: String? = TITLE_DEFAULT,
                isDismissable: Boolean = IS_DISMISSIBLE_DEFAULT
    ) : super(context) {
        initAttrs(hierarchy, type, body, title, isDismissable)
    }

    /**
     * Sets the proper [config] for this message based on the [attrs] received via XML.
     *
     * @param attrs attributes from the XML.
     */
    private fun initAttrs(attrs: AttributeSet?) {
        andesMessageAttrs = AndesMessageAttrsParser.parse(context, attrs)
        val config = AndesMessageConfigurationFactory.create(context, andesMessageAttrs)
        setupComponents(config)
    }


    private fun initAttrs(hierarchy: AndesMessageHierarchy, type: AndesMessageType, body: String, title: String?, isDismissable: Boolean) {
        andesMessageAttrs = AndesMessageAttrs(hierarchy, type, body, title, isDismissable)
        val config = AndesMessageConfigurationFactory.create(context, andesMessageAttrs)
        setupComponents(config)
    }

    /**
     * Responsible for setting up all properties of each component that is part of this button.
     * Is like a choreographer ;)
     *
     */
    private fun setupComponents(config: AndesMessageConfiguration) {
        radius = context.resources.getDimension(R.dimen.andesui_message_corner_radius)
        cardElevation = 0f
        preventCornerOverlap = true

        initComponents()
        setupViewId()

        setupColorComponents(config)
        setupDismissable(config)
    }

    private fun setupColorComponents(config: AndesMessageConfiguration) {
        setupTitleComponent(config)
        setupBodyComponent(config)
        setupBackground(config)
        setupPipe(config)
        setupIcon(config)
        setupButton(config)
    }

    /**
     * Creates all the views that are part of this message.
     * After a view is created then a view id is added to it.
     *
     */
    private fun initComponents() {
        val container = LayoutInflater.from(context).inflate(R.layout.andesui_layout_message, this, true)

        messageContainer = container.findViewById(R.id.andesui_message_container)
        titleComponent = container.findViewById(R.id.andesui_title)
        bodyComponent = container.findViewById(R.id.andesui_body)
        iconComponent = container.findViewById(R.id.andesui_icon)
        dismissableComponent = container.findViewById(R.id.andesui_dismissable)
        pipeComponent = container.findViewById(R.id.andesui_pipe)
        primaryAction = container.findViewById(R.id.andesui_primary_action)
        secondaryAction = container.findViewById(R.id.andesui_secondary_action)
    }

    /**
     * Sets a view id to this message.
     *
     */
    private fun setupViewId() {
        if (id == NO_ID) { //If this view has no id
            id = View.generateViewId()
        }
    }

    /**
     * Gets data from the config and sets to the text component of this button.
     *
     */
    private fun setupTitleComponent(config: AndesMessageConfiguration) {
        if (config.titleText == null || config.titleText.isEmpty()) {
            titleComponent.visibility = View.GONE
        } else {
            titleComponent.visibility = View.VISIBLE
            titleComponent.text = config.titleText
            titleComponent.setTextSize(TypedValue.COMPLEX_UNIT_PX, config.titleSize)
            titleComponent.setTextColor(config.textColor.colorInt(context))
            titleComponent.typeface = config.titleTypeface
        }
    }

    /**
     * Gets data from the config and sets to the text component of this button.
     *
     */
    private fun setupBodyComponent(config: AndesMessageConfiguration) {
        bodyComponent.text = config.bodyText
        bodyComponent.setTextSize(TypedValue.COMPLEX_UNIT_PX, config.bodySize)
        bodyComponent.setTextColor(config.textColor.colorInt(context))
        bodyComponent.typeface = config.bodyTypeface
//        bodyComponent.lineHeight = config.lineHeight //FIXME Use TextViewCompat
    }

    private fun setupBackground(config: AndesMessageConfiguration) {
        setCardBackgroundColor(config.backgroundColor.colorInt(context))
    }

    private fun setupPipe(config: AndesMessageConfiguration) {
        pipeComponent.setBackgroundColor(config.pipeColor.colorInt(context))
    }

    private fun setupIcon(config: AndesMessageConfiguration) {
        iconComponent.setImageDrawable(config.icon)
        dismissableComponent.setImageDrawable(config.dismissableIcon)
    }

    private fun setupDismissable(config: AndesMessageConfiguration) {
        if (config.isDismissable) {
            dismissableComponent.visibility = View.VISIBLE
            dismissableComponent.setOnClickListener {
                visibility = View.GONE
            }
        } else {
            dismissableComponent.visibility = View.GONE
        }
    }

    private fun setupButton(config: AndesMessageConfiguration) {
        primaryAction.changeBackgroundColor(config.primaryActionBackgroundColor)
        primaryAction.changeTextColor(config.primaryActionTextColor.colorInt(context))
        secondaryAction.changeBackgroundColor(config.secondaryActionBackgroundColor)
        secondaryAction.changeTextColor(config.secondaryActionTextColor.colorInt(context))
    }

    fun setupPrimaryAction(text: String, onClickListener: OnClickListener) {
        primaryAction.visibility = View.VISIBLE
        primaryActionText = text
        primaryAction.setOnClickListener(onClickListener)
    }

    fun setupSecondaryAction(text: String, onClickListener: OnClickListener) {
        if (primaryAction.visibility == View.VISIBLE) {
            secondaryAction.visibility = View.VISIBLE
            secondaryActionText = text
            secondaryAction.setOnClickListener(onClickListener)
        } else {
            when {
                BuildConfig.DEBUG -> throw IllegalStateException("Cannot initialize a secondary action without a primary one")
                else -> Log.d("AndesMessage", "Cannot initialize a secondary action without a primary one")
            }
        }
    }

    fun hidePrimaryAction() {
        primaryAction.visibility = View.GONE
        secondaryAction.visibility = View.GONE
    }

    fun hideSecondaryAction() {
        secondaryAction.visibility = View.GONE
    }

    private fun createConfig() = AndesMessageConfigurationFactory.create(context, andesMessageAttrs)

    companion object {
        private val HIERARCHY_DEFAULT = AndesMessageHierarchy.LOUD
        private val STATE_DEFAULT = AndesMessageType.NEUTRAL
        private val TITLE_DEFAULT = null
        private const val IS_DISMISSIBLE_DEFAULT = false
    }
}