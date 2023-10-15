package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animal1 = Animal("Merlin", "The British Shorthair is the " +
                "pedigreed version of the traditional British domestic cat, with " +
                "a distinctively stocky body, thick coat, and broad face. The most familiar " +
                "colour variant is the \"British Blue\", with a solid grey-blue coat, " +
                "pineapple eyes, and a medium-sized tail. The breed has also been developed " +
                "in a wide range of other colours and patterns, including tabby " +
                "and colourpoint. The breed's good-natured appearance and relatively calm " +
                "temperament make it a frequent media star, notably as the inspiration for John " +
                "Tenniel's famous illustration of the Cheshire Cat from Alice in Wonderland. ",
                "British Shorthair", R.drawable.british_cat)

        val animal2 = Animal("Apollo", "The German Shepherd, also known in Britain as an " +
                "Alsatian, is a German breed of working dog of medium to large size. " +
                "The breed was developed by Max von Stephanitz using various traditional " +
                "German herding dogs from 1899.\n" + "\n" + "It was originally bred as a " +
                "herding dog, for herding sheep. It has since been used in many other types " +
                "of work, including disability assistance, search-and-rescue, police work, " +
                "and warfare. It is commonly kept as a companion dog, and according " +
                "to the Fédération Cynologique Internationale had the second-highest number " +
                "of annual registrations in 2013.", "German Sheprherd", R.drawable.german_shepherd)

        val animal3 = Animal("Jackson", " The Shamrock Macaw is a very " +
                "popular pet bird with two very popular types of macaws as its parents. " +
                "The Scarlet Macaw, one of the most highly favored macaws, is described as " +
                "“beautiful and striking”. The Scarlet has been the best-known South American " +
                "parrot for over 100 years. The other parent, the Military Macaw, is also " +
                "a long time favorite pet macaw with a good temperament, very trainable, " +
                "and highly intelligent.\n" + "\n" + "   Hybrid macaws are bred for color. " +
                "Shamrock Macaws are a first-generation hybrid macaw, meaning its parents " +
                "are two species of naturally occurring macaws", "Shamrock Macaw", R.drawable.shamrock_macaw)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
            DataHolder.selectedAnimal = animal1
            startActivity(Intent(this, Activity2::class.java))
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
             DataHolder.selectedAnimal = animal2
             startActivity(Intent(this, Activity2::class.java))
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener{
             DataHolder.selectedAnimal = animal3
             startActivity(Intent(this, Activity2::class.java))
        }
    }
}

