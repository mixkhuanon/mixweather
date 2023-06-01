package com.example.mixweather.directweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mixweather.data.model.DirectWeatherResponseModel
import com.example.mixweather.data.model.LocationResponseModel
import com.example.mixweather.directweather.DirectWeatherFragment.Companion.ZERO_CONST
import com.example.mixweather.domain.GetDirectWeatherUseCase
import com.example.mixweather.domain.GetLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DirectWeatherViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
    private val getDirectWeatherUseCase: GetDirectWeatherUseCase
) : ViewModel() {

    private val _location: MutableLiveData<List<LocationResponseModel>> =
        MutableLiveData()
    val location: LiveData<List<LocationResponseModel>>
        get() = _location

    private val _directWeather: MutableLiveData<DirectWeatherResponseModel> =
        MutableLiveData()
    val directWeather: LiveData<DirectWeatherResponseModel>
        get() = _directWeather

    private val _onLocationError: MutableLiveData<Unit> = MutableLiveData()
    val onLocationError: LiveData<Unit>
        get() = _onLocationError

    private val _connectionLost: MutableLiveData<Unit> = MutableLiveData()
    val connectionLost: LiveData<Unit>
        get() = _connectionLost

    var directDegree: Double = ZERO_CONST

    fun getLocation(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getLocationUseCase.execute(city).let { response ->
                    if (response.isSuccessful) {
                        if (response.body()?.isNotEmpty() == true)
                            _location.postValue(response.body())
                    } else {
                        _onLocationError.postValue(Unit)
                    }
                }
            } catch (e: Exception) {
                _connectionLost.postValue(Unit)
            }
        }
    }

    fun getDirectWeather(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getDirectWeatherUseCase.execute(lat, lon).let { response ->
                    if (response.isSuccessful) {
                        _directWeather.postValue(response.body())
                    }
                }
            } catch (e: Exception) {
                _connectionLost.postValue(Unit)
            }
        }
    }
}