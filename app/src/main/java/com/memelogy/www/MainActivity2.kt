package com.memelogy.www

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {


   var currentImageUrl:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        loadmeme()
    }

    private fun loadmeme() {



        val image= findViewById<ImageView>(R.id.memeImageView)
        val textView = findViewById<TextView>(R.id.text)
// ...

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        currentImageUrl = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, currentImageUrl,null,
                Response.Listener { response ->
                    currentImageUrl=response.getString("url")
                    Glide.with(this).load(currentImageUrl).into(image)

                },
                Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)


    }

    fun shareMe(view: View){
        val intent=Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT,"oye jo dekho maja agaye ga $currentImageUrl")
        val chooser=Intent.createChooser(intent,"share this using.... ")
        startActivity(chooser)

    }

    fun nextMe(view: View){
        loadmeme()

    }
}