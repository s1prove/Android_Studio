package com.example.androidapp.presentation.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidapp.CountryAdapter
import com.example.androidapp.R
import com.example.androidapp.classes.Country
import com.example.androidapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Country>()
        list.add(Country("Kyiv", "Ukraine", "Kyiv", R.drawable.kyiv, "50.27", "30.31"))
        list.add(Country("Tirane", "Albania", "Tirane", R.drawable.tirane, "40", "20"))
        list.add(Country("Tripoli", "Libya", "Tripoli", R.drawable.tripoli, "25", "15"))
        list.add(Country("Madrid", "Spain", "Madrid" , R.drawable.madrid, "40", "5"))
        list.add(Country("Tunis", "Tunis", "Tunis" , R.drawable.tunis, "35", "10"))


        adapter = CountryAdapter(){ country, position ->
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(country.name, country.description, country.image, country.lat, country.lon))
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

//        binding.buttonTo2.setOnClickListener{
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment("Something", "Something", 1))
//        }
    }
}
