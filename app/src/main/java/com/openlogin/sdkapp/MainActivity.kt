package com.openlogin.sdkapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.openlogin.core.OpenLogin

class MainActivity : AppCompatActivity() {
    private lateinit var openlogin: OpenLogin

    private fun reRender() {
        val button = findViewById<Button>(R.id.button)

        if (openlogin.state.privKey != null) {
            button.text = getString(R.string.show_private_key)
            button.setOnClickListener {
                Toast.makeText(this, "Private key: ${openlogin.state.privKey}", Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            button.text = getString(R.string.sign_in)
            button.setOnClickListener {
                openlogin.login()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure OpenLogin
        openlogin = OpenLogin(
            this,
            clientId = getString(R.string.openlogin_client_id),
            network = OpenLogin.Network.MAINNET,
            redirectUrl = Uri.parse("com.openlogin.sdkapp://auth"),
        )

        // Handle user signing in when app is not alive
        openlogin.setResultUrl(intent?.data)
        reRender()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        // Handle user signing in when app is active
        openlogin.setResultUrl(intent?.data)
        reRender()
    }
}