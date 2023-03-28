package com.example.mainviewmodel

import com.squareup.picasso.Picasso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.viewModels
import com.project1.mainviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getDogImageNetworkCall(binding.immageDog)

        viewModel.dogImage.observe(this) { dogImage ->
            when (dogImage) {
                is Response.Error -> Toast.makeText(this, "no", LENGTH_LONG).show()
                Response.Loading -> Toast.makeText(this, "loading", LENGTH_LONG).show()
                is Response.Success <DtoObject> -> Picasso.get().load(dogImage.body?.message)
                    .into(binding.immageDog)
            }
        }
        binding.immageDog.visibility = View.VISIBLE
    }
}