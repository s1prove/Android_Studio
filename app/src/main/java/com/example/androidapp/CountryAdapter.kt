package com.example.androidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidapp.classes.Country
import com.example.androidapp.databinding.ItemAnimalBinding

class CountryAdapter(
    val onClick:(country: Country, position: Int) -> Unit
) : RecyclerView.Adapter<CountryAdapter.FoodViewHolder>() {

    private val list = ArrayList<Country>()

    fun setList(newList: List<Country>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    inner class FoodViewHolder(val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(element:Country, position: Int){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element, position)

    }

}