package com.apollyon.hybrid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var counterLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterLabel = findViewById(R.id.counter_label)

        val button = findViewById<Button>(R.id.launch_button)
        val app = application as MyApplication
        app.setToken()

        button.setOnClickListener {
            val intent = FlutterActivity
                .withCachedEngine(ENGINE_ID)
                .build(this)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
