package com.example.kotlinhw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinhw2.extension.loadImage
import com.example.kotlinhw2.extension.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val images = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addImage()

        imgView.loadImage(
            "http://developer.alexanderklimov.ru/android/images/android_cat.jpg",
            this
        )

        submitBtn.setOnClickListener {
            if (et.text.trim().isNotEmpty()) {
                images.add(et.text.toString())
                applicationContext.showToast(images.toString())
            } else {
                applicationContext.showToast("Введите текст")
            }
        }
        randomBtn.setOnClickListener {
            imgView.loadImage(images.random(), this)
        }
    }

    private fun addImage() {
        images.add("https://www.wallpaperup.com/uploads/wallpapers/2014/02/01/244212/24e483f8bc082d6b0f907a050956d627-700.jpg")
        images.add("https://i.pinimg.com/originals/49/c7/61/49c7611a1d83ec98b2878c26aa9d9b59.jpg")
        images.add("https://images4.alphacoders.com/692/692903.jpg")
        images.add("https://wallup.net/wp-content/uploads/2016/01/259442-video_games-The_Elder_Scrolls_V_Skyrim-748x421.png")
        images.add("https://i.pinimg.com/originals/68/17/d0/6817d0b4bbcbaa53177877c85ce7222f.jpg")
    }
}
