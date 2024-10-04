package com.example.musicappxml

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var play = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<ImageView>(R.id.play)

        playButton.setOnClickListener {
            play = !play
            if (play) {
                playButton.setImageResource(R.drawable.pausecircle)
            } else {
                playButton.setImageResource(R.drawable.playcircle)
            }
        }

        enableEdgeToEdge()

    }
}

