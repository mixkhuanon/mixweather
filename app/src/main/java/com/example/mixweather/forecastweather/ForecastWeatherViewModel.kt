package com.example.mixweather.forecastweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mixweather.data.model.ForecastWeatherResponseModel
import com.example.mixweather.data.model.directweather.Coord
import com.example.mixweather.domain.GetForecastWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastWeatherViewModel @Inject constructor(
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase
) : ViewModel() {
    var coord: Coord? = Coord()

    private val _forecastWeather: MutableLiveData<ForecastWeatherResponseModel> =
        MutableLiveData()
    val forecastWeather: LiveData<ForecastWeatherResponseModel>
        get() = _forecastWeather

    private val _onForecastWeatherError: MutableLiveData<Unit> =
        MutableLiveData()
    val onForecastWeatherError: LiveData<Unit>
        get() = _onForecastWeatherError

    private val _onError: MutableLiveData<Unit> = MutableLiveData()
    val onError: LiveData<Unit>
        get() = _onError

    fun getForecastWeather() {
        coord?.let {
            val lat = it.lat
            val lon = it.lon
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    getForecastWeatherUseCase.execute(lat = lat, lon = lon).let { response ->
                        if (response.isSuccessful) {
                            if (response.body()?.city.toString().isNotEmpty())
                                _forecastWeather.postValue(response.body())
                        } else {
                            _onForecastWeatherError.postValue(Unit)
                        }
                    }
                } catch (e: Exception) {
                    _onError.postValue(Unit)
                }
            }
        }
    }
}