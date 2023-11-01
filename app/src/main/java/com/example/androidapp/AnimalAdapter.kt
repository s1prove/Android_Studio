package com.example.androidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidapp.classes.Food
import com.example.androidapp.databinding.ItemAnimalBinding

class AnimalAdapter(
    val onClick:(animal: Food, position: Int) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private val list = ArrayList<Food>()

    fun setList(newList: List<Food>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    inner class AnimalViewHolder(val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(element:Food, position: Int){
            binding.Name.text = element.name
            binding.Description.text = element.country
            binding.btn.setOnClickListener{
                onClick(element, position)
            }

            Glide.with(binding.iv1.context)
                .load(element.image)
                .into(binding.iv1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element, position)

    }

}