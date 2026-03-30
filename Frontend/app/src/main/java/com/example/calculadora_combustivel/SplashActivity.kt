package com.example.calculadora_combustivel

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val container = findViewById<View>(R.id.centerContainer)

        // 🔥 Estado inicial (invisível e menor)
        container.alpha = 0f
        container.scaleX = 0.8f
        container.scaleY = 0.8f

        // 🔥 Animação (fade + zoom)
        container.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(800)
            .start()

        // 🔥 Navegação após delay
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500)
    }
}