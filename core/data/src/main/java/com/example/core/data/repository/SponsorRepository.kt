package com.example.core.data.repository

import com.example.core.model.Sponsor

interface SponsorRepository {

    suspend fun getSponsors(): List<Sponsor>
}