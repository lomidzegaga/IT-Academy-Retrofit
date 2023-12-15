package com.example.retrofit

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RestaurantViewModel
    private val viewModelFactory = RestaurantViewModelFactory(RetrofitClient.retrofit)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(RestaurantViewModel::class.java)

        lifecycleScope.launch {
            viewModel.getData().collect {
                d("!!!!!!!", it.toString())
            }
        }
    }
}

class RestaurantViewModelFactory(
    private val api: RestaurantApi
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RestaurantViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown VieModel class")
    }
}