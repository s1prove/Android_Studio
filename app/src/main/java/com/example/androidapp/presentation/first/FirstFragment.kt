package com.example.androidapp.presentation.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidapp.CountryAdapter
import com.example.androidapp.data.local.Country
import com.example.androidapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    lateinit var adapter: CountryAdapter

    lateinit var viewModel: FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val data : List<Country> = viewModel.getCountry()

        viewModel.getCountry()

        viewModel.countryLd.observe(viewLifecycleOwner){

            adapter = CountryAdapter(){ country, position ->
                findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(country.name, country.description, country.image, country.lat, country.lon))
            }
            if(it != null){
                adapter.setList(it)
                binding.rv.adapter = adapter
            }
        }

//        adapter = CountryAdapter(){ country, position ->
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(country.name, country.description, country.image, country.lat, country.lon))
//        }
//        adapter.setList(data)
//        binding.rv.adapter = adapter

//        binding.buttonTo2.setOnClickListener{
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment("Something", "Something", 1))
//        }
    }
}
