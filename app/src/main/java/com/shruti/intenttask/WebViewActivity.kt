package com.shruti.intenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.shruti.intenttask.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    lateinit var binding : ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val webSettings :WebSettings =  binding.web.settings
        binding.web.getSettings().setSupportMultipleWindows(true)
        webSettings.javaScriptEnabled = true
        binding.web.webViewClient = WebViewClient()
        binding.web.loadUrl("https://www.youtube.com/playlist?list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt")
        binding.web.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (binding.web.canGoBack()){
            binding.web.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}