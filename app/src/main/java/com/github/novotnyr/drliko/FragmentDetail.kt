package com.github.novotnyr.drliko

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.novotnyr.drliko.databinding.FragmentDetailBinding

class FragmentDetail : Fragment() {
    lateinit var binding: FragmentDetailBinding

    private val cityViewModel: CityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cityViewModel.selectedCity.observe(viewLifecycleOwner, ::setTemperature)
    }

    private fun setTemperature(city: String) {
        val temperature = city.hashCode() % 32 // vypocet teploty pre mesto
        binding.temperatureTextView.text = "$temperature °C"
    }
}