package com.example.mixweather.directweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mixweather.R
import com.example.mixweather.databinding.FragmentDirectWeatherBinding
import com.example.mixweather.utils.Extensions.toCelsius
import com.example.mixweather.utils.Extensions.toFahrenheit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DirectWeatherFragment : Fragment() {

    private lateinit var viewModel: DirectWeatherViewModel

    private var binding: FragmentDirectWeatherBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DirectWeatherViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDirectWeatherBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observable()
        initListener()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun observable() {
        viewModel.location.observe(viewLifecycleOwner) {
            it.first().apply {
                binding?.location?.text = name.toString()
                viewModel.getDirectWeather(lat, lon)
            }
        }
        viewModel.directWeather.observe(viewLifecycleOwner) {
            viewModel.directDegree = it.main?.temp ?: 0.0
            showDirectDegree()
        }
        viewModel.connectionLost.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Connection Lost", Toast.LENGTH_SHORT).show()
        }
        viewModel.onLocationError.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Not found this location", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListener() {
        binding?.buttonSearch?.setOnClickListener {
            val searchText = binding?.searchEdittext?.text.toString()
            binding?.searchEdittext?.clearFocus()
            viewModel.getLocation(searchText)
        }
        binding?.searchEdittext?.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding?.searchEdittext?.clearFocus()
                viewModel.getLocation(binding?.searchEdittext?.text.toString())
                binding?.toggleDegree?.visibility = View.VISIBLE
            }
            return@setOnEditorActionListener false
        }
        binding?.toggleDegree?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.directDegree = viewModel.directDegree.toFahrenheit()
            } else {
                viewModel.directDegree = viewModel.directDegree.toCelsius()
            }
            showDirectDegree()
        }
    }

    private fun showDirectDegree() {
        val degree = String.format("%.2f", viewModel.directDegree) + getString(R.string.degrees)
        binding?.temp?.text = degree
    }
}