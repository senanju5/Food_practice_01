package com.example.food_practice_01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.food_practice_01.data.model.FoodRecipe
import com.example.food_practice_01.databinding.FoodItemViewBinding

class RecipeListViewAdapter(private val onItemClick: (position: Int) -> Unit) :
    ListAdapter<FoodRecipe, RecipeListViewAdapter.RecipeViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FoodRecipe>() {
            override fun areItemsTheSame(oldItem: FoodRecipe, newItem: FoodRecipe): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FoodRecipe, newItem: FoodRecipe): Boolean {
                return oldItem == newItem
            }

        }
    }


    class RecipeViewHolder(private val binding: FoodItemViewBinding, private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: FoodRecipe, position: Int) {
            binding.foodImagView.load(recipe.image) {
                crossfade(true)
                crossfade(600)
            }
            binding.titleTextView.text = recipe.title
            binding.priceTextView.text = recipe.pricePerServing.toString()
            itemView.setOnClickListener{
                onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            FoodItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding, onItemClick )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}