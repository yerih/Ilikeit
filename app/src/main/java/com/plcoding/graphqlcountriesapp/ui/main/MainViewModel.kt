package com.plcoding.graphqlcountriesapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.domain.countries
import com.plcoding.graphqlcountriesapp.usecases.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.usecases.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val countryUseCase: GetCountryUseCase,
    private val countriesUseCase: GetCountriesUseCase
) : ViewModel(){

    data class UiState(
        val loading: Boolean = false,
        val list: List<Country> = countries,
    )

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    sealed interface UiEvent {
        data class ToastEvent(val msg: String): UiEvent
    }
    private val _events = Channel<UiEvent>()
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            val result = countriesUseCase.execute()
            if(result.isError())
                _events.send(UiEvent.ToastEvent(result.error!!.message.toString()))
            else
                _state.update { it.copy(list = result.value!!) }
        }
    }
}