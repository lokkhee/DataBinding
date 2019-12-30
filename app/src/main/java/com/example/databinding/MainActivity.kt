package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var myContact: Contact = Contact("ABC","123")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.contact = myContact

        binding.buttonDone.setOnClickListener{
            updateName()
        }
    }

    fun updateName(){
        binding.apply{
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhoneNumber.text.toString()
            this.invalidateAll()

        }
    }
}
