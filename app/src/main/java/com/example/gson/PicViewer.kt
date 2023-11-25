package com.example.gson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.gson.Gson

class PicViewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_viewer)

        val link = intent.getStringExtra("Link")
        val image = findViewById<ImageView>(R.id.imageView2)
        Glide.with(this).load(link).into(image)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.tool_bar_viewer)
        setSupportActionBar(toolbar)
        title = "GSON"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.heart_id -> showToast()
        }
        return super.onOptionsItemSelected(item)
    }

    fun showToast(){
        val message = "Добавлено в Избранное"
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()

        val answerIntent = Intent()
        answerIntent.putExtra("message", intent.getStringExtra("Link"))
        setResult(RESULT_OK, answerIntent)
        finish()
    }
}



