package com.example.mixweather.forecastweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mixweather.databinding.FragmentForecastWeatherBinding
import com.example.mixweather.forecastweather.adapter.ForecastWeatherListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ForecastWeatherFragment : Fragment() {

    private lateinit var viewModel: ForecastWeatherViewModel

    @Inject
    lateinit var forecastWeatherListAdapter: ForecastWeatherListAdapter

    private var binding: FragmentForecastWeatherBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ForecastWeatherViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastWeatherBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recycleViewForecastWeather?.apply {
            adapter = forecastWeatherListAdapter
        }
        observable()
        initListener()
    }

    override fun onResume() {
        super.onResume()
        initDate()
    }

    private fun initDate() {
        arguments?.let {
            ForecastWeatherFragmentArgs.fromBundle(it).let { args ->
                viewModel.coord?.apply {
                    lat = args.lat.toDouble()
                    lon = args.lon.toDouble()
                }
            }
            viewModel.getForecastWeather()
        }
    }

    private fun observable() {
        viewModel.forecastWeather.observe(viewLifecycleOwner) {
            binding?.recycleViewForecastWeather?.rootView?.visibility = View.VISIBLE
            forecastWeatherListAdapter.submitList(it.list)
        }
        viewModel.connectionLost.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
        viewModel.onForecastWeatherError.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Not found this location.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListener() {
        binding?.buttonBack?.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}