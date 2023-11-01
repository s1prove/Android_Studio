package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidapp.classes.Food
import com.example.androidapp.classes.Indian
import com.example.androidapp.classes.Italian
import com.example.androidapp.classes.Spanish
import com.example.androidapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    lateinit var adapter: FoodAdapter

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

        val list = ArrayList<Food>()
        list.add(Italian("Pasta", "Italian food", "Pasta is a type of food typically made from an unleavened dough of wheat flour mixed with water or eggs, " +
                "and formed into sheets or other shapes, then cooked by boiling or baking. Rice flour, or legumes such as beans or lentils, are sometimes used in place of wheat " +
                "flour to yield a different taste and texture, or as a gluten-free alternative. Pasta is a staple food of Italian cuisine.", R.drawable.pasta))
        list.add(Indian("Masala", "Indian food", "Masala Dosa, also called Masale dosey, is a South Indian dish. It is a type of dosa and " +
                "has its origin in the town of Udupi in Karnataka. It is made from rice, lentils, Urad dal, Chana dal, fenugreek, puffed rice, Toor dal, dry red chilli " +
                "and served with potato curry, chutneys, and sambar. It is popular in South India, but can be found in all other parts of the country and overseas. " +
                "In South India, the preparation of masala dosa varies from city to city. There are variations in Masala dosa like Davanagere butter dosa " +
                "and paper masala dosa. ", R.drawable.masala_dosa))
        list.add(Spanish("Paella", "Spanish food", "Paella is a rice dish originally from the Valencian Community. Paella is regarded as one of the community's identifying symbols. It is one of the best-known dishes in Spanish cuisine.\n" +
                "\n" +
                "The dish takes its name from the wide, shallow traditional pan used to cook the dish on an open fire, paella being the word for a frying " +
                "pan in Valencian/Catalan language. As a dish, it may have ancient roots, but in its modern form, it is traced back to the mid-19th century, " +
                "in the rural area around the Albufera lagoon adjacent to the city of Valencia, on the Mediterranean coast of Spain.", R.drawable.paella))
        list.add(Indian("Chaat", "Indian food", "Chaat, or chāt is a family of savoury snacks that originated in India, typically " +
                "served as an hors d'oeuvre or at roadside tracks from stalls or food carts across South Asia in India, Pakistan, Nepal and Bangladesh. " +
                "With its origins in Uttar Pradesh, India, chaat has become immensely popular in the rest of South Asia. The chaat variants are all based on " +
                "fried dough, with various other ingredients. The original chaat is a mixture of potato pieces, crisp fried bread dahi vada or dahi bhalla, gram " +
                "or chickpeas and tangy-salty spices, with sour Indian chili" , R.drawable.chaat))

        adapter = FoodAdapter(){ food, position ->
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(food.name, food.description, food.image))
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

//        binding.buttonTo2.setOnClickListener{
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment("Something", "Something", 1))
//        }
    }
}
