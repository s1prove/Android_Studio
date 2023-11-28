package com.example.androidapp.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch



class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding

    val args: SecondFragmentArgs by navArgs()

//    lateinit var adapter: SecondAnimalAdapter
    lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: SecondFragmentArgs by navArgs()
        val temp_tv = view.findViewById<TextView>(R.id.temp)
        val feel_tv = view.findViewById<TextView>(R.id.feels_like)
        val cloud_tv = view.findViewById<TextView>(R.id.clouds)
        val wind_tv = view.findViewById<TextView>(R.id.wind_speed)
        val second_tv = view.findViewById<TextView>(R.id.name)
        val img = view.findViewById<ImageView>(R.id.img)
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)

        img.setImageResource(args.image)



        val button = view.findViewById<Button>(R.id.buttonTo1)
        button.setOnClickListener{ findNavController().navigate(R.id.action_secondFragment_to_firstFragment2)
        }


        viewModel.getWeather(args.lat, args.lon)


        viewModel.weatherLd.observe(viewLifecycleOwner){
            second_tv.text = it?.timezone

            temp_tv.text = it?.current?.temp.toString() + "°C"

            feel_tv.text = it?.current?.feels_like.toString() + "°C"

            cloud_tv.text = it?.current?.clouds.toString() + "%"

            wind_tv.text = it?.current?.wind_speed.toString() + "m/s"

        }
        viewModel.isLoading.observe(viewLifecycleOwner){
            if(!it)
                swipe.isRefreshing = false
        }
    }

}
