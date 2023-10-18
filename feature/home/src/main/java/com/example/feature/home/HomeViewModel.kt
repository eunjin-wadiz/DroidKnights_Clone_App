package com.example.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.usecase.GetSponsorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getSponsorsUseCase: GetSponsorsUseCase
): ViewModel() {

    val sponsorsUiState: StateFlow<SponsorsUiState> = flow { emit(getSponsorsUseCase()) }
        .map { sponsors ->
            if (sponsors.isNotEmpty()) {
                SponsorsUiState.Sponsors(sponsors)
            } else {
                SponsorsUiState.Empty
            }
        }
        .catch {

        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SponsorsUiState.Loading,
        )

}