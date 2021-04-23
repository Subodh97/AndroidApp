package com.capgemini.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowContentAccess = true
        webView.loadUrl("https://www.capgemini.com")
    }
}