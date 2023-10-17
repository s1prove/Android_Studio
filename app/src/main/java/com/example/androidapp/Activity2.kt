package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var button2 = findViewById<Button>(R.id.buttonBack)
        button2.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }

        val animalName = intent.getStringExtra("animalName")
        val animalDescription = intent.getStringExtra("animalDescription")
        val animalBreedText = intent.getStringExtra("breed")
        val animalImageResId = intent.getIntExtra("animalImageResId", 1)

        val animalImage = findViewById<ImageView>(R.id.imageView)
        val animalNameView = findViewById<TextView>(R.id.textViewFor1)
        val animalBreed = findViewById<TextView>(R.id.textViewFor3)
        val animalDescriptionView = findViewById<TextView>(R.id.textViewFor2)


        animalImage.setImageResource(animalImageResId)
        animalNameView.text = animalName
        animalBreed.text = animalBreedText
        animalDescriptionView.text = animalDescription
        }
}
