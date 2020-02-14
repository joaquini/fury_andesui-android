package com.mercadolibre.android.andesui.demoapp

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.andesui_demoapp_main.*

/**
 * Main activity class
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.andesui_demoapp_main)

        setupButtons()
        setupMessages()
        setupWhatsNew()
        setupAndesSpecsWeb()
    }

    private fun setupButtons() {
        andesui_buttons.setOnClickListener {
            launchIntent("meli://andes/button")
        }
    }

    private fun setupMessages() {
        andesui_messages.setOnClickListener {
            launchIntent("meli://andes/message")
        }
    }

    private fun setupWhatsNew() {
        andesui_demoapp_changelog.setOnClickListener {
            launchIntent("meli://andes/whats-new")
        }
    }

    private fun setupAndesSpecsWeb() {
        andesui_demoapp_andes_specs.setOnClickListener {
            launchSpecs(this, AndesSpecs.HOME_PAGE)
        }
    }

    private fun launchIntent(uri: String) {
        val launchIntent = Intent(ACTION_VIEW, Uri.parse(uri))
        startActivity(launchIntent)
    }
}