package com.sabanciuniv.edu.finalprojectataberkresatozek.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.sabanciuniv.edu.finalprojectataberkresatozek.R
import com.sabanciuniv.edu.finalprojectataberkresatozek.databinding.FragmentAnasayfaBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.sabanciuniv.edu.finalprojectataberkresatozek.services.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnasayfaFragment : Fragment() {
    private var _binding: FragmentAnasayfaBinding? = null
    private val binding get() = _binding!!
    private lateinit var mealAdapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())
        binding.kisilerRv.layoutManager = GridLayoutManager(requireContext(), 2)
        fetchMeals()
    }

    private fun fetchMeals() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.getMeals()
                if (response.success == 1) {
                    withContext(Dispatchers.Main) {
                        mealAdapter = MealAdapter(response.yemekler)
                        binding.kisilerRv.adapter = mealAdapter
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace() // Handle the exception appropriately
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
