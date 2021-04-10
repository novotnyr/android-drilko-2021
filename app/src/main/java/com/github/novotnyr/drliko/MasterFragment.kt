package com.github.novotnyr.drliko

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.novotnyr.drliko.databinding.FragmentMasterBinding

class MasterFragment : Fragment() {
    private lateinit var binding: FragmentMasterBinding

    private val cityViewModel: CityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cityListView.setOnItemClickListener { _, _, position, _ ->
            val city = binding.cityListView.getItemAtPosition(position) as String
            cityViewModel.setSelectedCity(city)
        }
    }
}