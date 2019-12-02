package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    var like: Int = 0
    var dislike: Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)


        Log.d("MainActivity", "onCreate")

        imageViewLike.setOnClickListener {
            like++
            textViewLikeCounter.text = like.toString()
        }

        imageViewDislike.setOnClickListener{
            dislike++
            textViewDislikeCounter.text = dislike.toString()
        }
    }
    override fun onPause(){
        Log.d("MainActivity","onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like),like)
            putInt(getString(R.string.dislike),dislike)
            commit()
        }
        super.onPause()
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        //Retrieve counters from the SharedPreferences
        like = sharedPreferences.getInt(getString(R.string.like),0)
        dislike = sharedPreferences.getInt(getString(R.string.dislike),0)

        textViewLikeCounter.text = like.toString()
        textViewDislikeCounter.text = dislike.toString()
        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onDestroy(){
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
