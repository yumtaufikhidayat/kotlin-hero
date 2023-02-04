package com.taufik.kotlinhero.ui

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.taufik.kotlinhero.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashscreenBinding.inflate(layoutInflater) }
    private var handler: Handler? = null
    private val delayInMillis = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSplashscreen()
        setAppVersion()
    }

    private fun setSplashscreen() {

        handler = Handler(Looper.getMainLooper())
        handler?.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delayInMillis)
    }

    private fun setAppVersion() {
        binding.apply {
            try {
                val pInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
                val appVersion = pInfo.versionName
                tvAppVersion.text = appVersion
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}