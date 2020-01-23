package com.mercadolibre.android.andesui.message

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.message.factory.AndesMessageConfiguration
import com.mercadolibre.android.andesui.message.factory.AndesMessageFactory
import com.mercadolibre.android.andesui.message.hierarchy.AndesMessageHierarchy
import com.mercadolibre.android.andesui.message.state.AndesMessageState


class AndesMessage : FrameLayout {

    private lateinit var messageContainer: ConstraintLayout
    private lateinit var titleComponent: TextView
    private lateinit var descriptionComponent: TextView
    private lateinit var iconComponent: ImageView
    private lateinit var dismissableComponent: ImageView
    private lateinit var pipeComponent: View
    private lateinit var config: AndesMessageConfiguration

    constructor(context: Context) : super(context) {
        initAttrs(AndesMessageHierarchy.LOUD, AndesMessageState.HIGHLIGHT, false) //FIXME Programmatic way
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context) {
        initAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context) {
        initAttrs(attrs)
    }

    constructor(context: Context, andesMessageHierarchy: AndesMessageHierarchy, andesMessageState: AndesMessageState, andesMessageIsDismissable: Boolean) : super(context) {
        initAttrs(andesMessageHierarchy, andesMessageState, andesMessageIsDismissable)
    }

    constructor(context: Context, andesMessageHierarchy: AndesMessageHierarchy, andesMessageState: AndesMessageState) : super(context) {
        initAttrs(andesMessageHierarchy, andesMessageState, false)
    }

    /**
     * Sets the proper [config] for this message based on the [attrs] received via XML.
     *
     * @param attrs attributes from the XML.
     */
    private fun initAttrs(attrs: AttributeSet?) {
        config = AndesMessageFactory.create(context, attrs)
        setupComponents()
    }


    private fun initAttrs(andesMessageHierarchy: AndesMessageHierarchy, andesMessageState: AndesMessageState, andesMessageIsDismissable: Boolean) {
        config = AndesMessageFactory.create(context, andesMessageHierarchy, andesMessageState, andesMessageIsDismissable)
        setupComponents()
    }

    /**
     * Responsible for setting up all properties of each component that is part of this button.
     * Is like a choreographer ;)
     *
     */
    private fun setupComponents() {
        initComponents()
        setupViewId()

        setupTitleComponent()

        setupDescriptionComponent()

        setupBackground()

        setupPipe()

        setupIcon()

        setupDismissable()
    }


    /**
     * Creates all the views that are part of this button.
     * After a view is created then a view id is added to it.
     *
     */
    private fun initComponents() {
        val container = LayoutInflater.from(context).inflate(R.layout.andesui_layout_message, this, true)

        messageContainer = container.findViewById(R.id.andesui_message_container)
        titleComponent = container.findViewById(R.id.andesui_title)
        descriptionComponent = container.findViewById(R.id.andesui_description)
        iconComponent = container.findViewById(R.id.andesui_icon)
        dismissableComponent = container.findViewById(R.id.andesui_dismissable)
        pipeComponent = container.findViewById(R.id.andesui_pipe)
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
    private fun setupTitleComponent() {
        titleComponent.text = config.titleText
        titleComponent.setTextSize(TypedValue.COMPLEX_UNIT_PX, config.titleSize)
        titleComponent.setTextColor(config.textColor)
        titleComponent.typeface = config.titleTypeface
    }

    /**
     * Gets data from the config and sets to the text component of this button.
     *
     */
    private fun setupDescriptionComponent() {
        descriptionComponent.text = config.descriptionText
        descriptionComponent.setTextSize(TypedValue.COMPLEX_UNIT_PX, config.descriptionSize)
        descriptionComponent.setTextColor(config.textColor)
        descriptionComponent.typeface = config.descriptionTypeface
//        descriptionComponent.lineHeight = config.lineHeight //FIXME Use TextViewCompat
    }

    private fun setupBackground() {
//        messageContainer.clipToOutline = true
        messageContainer.background = config.backgroundColor
    }

    private fun setupPipe() {
        pipeComponent.setBackgroundColor(config.pipeColor)
    }

    private fun setupIcon() {
        iconComponent.setImageDrawable(config.icon)
        dismissableComponent.setImageDrawable(config.dismisssableIcon)
    }

    private fun setupDismissable() {
        if (!config.dismissable) {
            dismissableComponent.visibility = View.GONE
        }
    }

    fun setTitle(string: String) {
        titleComponent.text = string
    }

    fun setDescription(string: String) {
        descriptionComponent.text = string
    }

    //TODO Checks if applies
    fun setDismissable(dismissable: Boolean) {
        if (!dismissable) {
            dismissableComponent.visibility = View.GONE
        }
    }

    //What about moving all of this to a delegate? That delegate would be in charge of knowing if API 21 or not.
    //See https://github.com/JcMinarro/RoundKornerLayouts/blob/master/roundkornerlayout/src/main/java/com/jcminarro/roundkornerlayout/CanvasRounder.kt
    private var rectF: RectF? = null
    private val path = Path()
    private val cornerRadius = 100f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectF = RectF(0f, 0f, w.toFloat(), h.toFloat())
        resetPath()
    }

    override fun draw(canvas: Canvas) {
        val save: Int = canvas.save()
        canvas.clipPath(path)
        super.draw(canvas)
        canvas.restoreToCount(save)
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save: Int = canvas.save()
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    private fun resetPath() {
        path.reset()
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        path.close()
    }
}