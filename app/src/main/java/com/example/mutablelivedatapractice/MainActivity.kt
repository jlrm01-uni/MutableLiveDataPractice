package com.example.mutablelivedatapractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mutablelivedatapractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val model: TestModel by viewModels()

        model.name.observe(this, Observer {
           binding.nameTextView.text = it
        })

        model.count.observe(this, Observer {
            binding.numberTextView.text = it.toString()
        })

        model.name.value = "New Name"
        model.count.value = 15

        binding.plusButton.setOnClickListener {
            changeCounter(1)
        }

        binding.minusButton.setOnClickListener {
            changeCounter(-1)
        }
    }

    fun changeCounter(increase_by: Int = 1) {
        val model: TestModel by viewModels()

        model.count.value = model.count.value?.plus(increase_by)
    }
}