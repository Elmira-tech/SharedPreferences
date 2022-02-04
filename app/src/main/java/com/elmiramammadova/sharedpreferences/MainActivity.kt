package com.elmiramammadova.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences=this.getSharedPreferences("com.elmiramammadova.sharedpreferences",
            MODE_PRIVATE)

        val ageFromSP=sharedPreferences.getInt("age",-1)
        if(ageFromSP==-1){
            textView.text="Your age: "
        }
        else{
            textView.text="Your age: ${ageFromSP}"
        }
    }

    fun Save(view: View){
        val myAge=plainText.text.toString().toIntOrNull()
        if(myAge!=null){
            textView.text="Your age: "+myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }

    fun Delete (view: View){
        val ageFromSP=sharedPreferences.getInt("age",-1)
        if(ageFromSP!=-1){
            sharedPreferences.edit().remove("age").apply()
            textView.text="Your age: "
        }
    }
}