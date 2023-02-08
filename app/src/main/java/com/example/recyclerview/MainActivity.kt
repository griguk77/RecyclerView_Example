package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    lateinit var cities: List<City>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fileCities = application.assets.open("cities.json").bufferedReader().use { it.readText() }
        val gson = GsonBuilder().create()
        cities = gson.fromJson(fileCities, Array<City>::class.java).toList()
        val adapter = MyAdapter(cities)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        sortBy()
    }

    fun sortBy() {
        binding.btnName.setOnClickListener {
            binding.recyclerView.adapter = MyAdapter(cities.sortedBy { it.name })
        }
        binding.btnCode.setOnClickListener {
            binding.recyclerView.adapter = MyAdapter(cities.sortedBy { it.code })
        }
        binding.btnPop.setOnClickListener {
            binding.recyclerView.adapter = MyAdapter(cities.sortedBy { it.population })
        }
    }
}

data class City(val name: String, val code: String, val population: Long)