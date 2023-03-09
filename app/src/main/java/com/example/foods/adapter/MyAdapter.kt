package com.example.foods.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foods.databinding.ItemViewBinding
import com.example.foods.models.Product

class MyAdapter (private val context: Context, private val foodList: List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val foods = foodList[position]
        holder.binding.tvId.text = foods.id.toString()
        holder.binding.tvTitle.text = foods.title
        Glide.with(context).load(foods.image).into(holder.binding.imageView)
//        holder.binding.root.setOnClickListener {
//            onItemClicked(Product())
//        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class MyViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}