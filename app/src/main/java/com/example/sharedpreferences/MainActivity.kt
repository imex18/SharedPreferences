package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btn_save.setOnClickListener {

            val firstName = et_first_name.text.toString()
            val lastName = et_last_name.text.toString()
            val isAdult = checkBox.isChecked

            editor.apply{

                putString("first name",firstName)
                putString("last name", lastName)
                putBoolean("is adult", isAdult)
                apply()
            }

        }

        btn_load.setOnClickListener {

            val firstName = sharedPref.getString("first name", null)
            val lastName = sharedPref.getString("last name", null)
            val isAdult = sharedPref.getBoolean("is adult", false)

            et_first_name.setText(firstName)
            et_last_name.setText(lastName)
            checkBox.isChecked = isAdult

        }



    }
}