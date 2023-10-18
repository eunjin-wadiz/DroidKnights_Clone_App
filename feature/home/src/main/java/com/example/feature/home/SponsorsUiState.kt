package com.example.feature.home

import com.example.core.model.Sponsor

sealed interface SponsorsUiState {
    object Loading : SponsorsUiState

    object Empty : SponsorsUiState

    data class Sponsors(
        val sponsors: List<Sponsor>,
    ) : SponsorsUiState
}