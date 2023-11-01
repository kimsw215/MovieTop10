package com.example.movietop10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movietop10.databinding.ActivityMovierankBinding

class MovieRankActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovierankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovierankBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}