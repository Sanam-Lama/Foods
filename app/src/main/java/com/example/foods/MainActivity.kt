package com.example.foods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foods.adapter.MyAdapter
import com.example.foods.databinding.ActivityMainBinding
import com.example.foods.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainActivityViewModel>()
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize binding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        callObservers()
    }

    private fun callObservers() {
        viewModel.foods.observe(this, Observer {
            Log.d("MAINACTIVITY, FOODS", it.products.toString())
            adapter = MyAdapter(this, it.products)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.itemAnimator = DefaultItemAnimator()
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()

        })
        viewModel.getFoods()
    }

//    private fun onItemClicked() {
//
//    }
}