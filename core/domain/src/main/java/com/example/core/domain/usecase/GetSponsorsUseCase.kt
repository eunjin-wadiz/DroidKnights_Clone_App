package com.example.core.domain.usecase

import com.example.core.data.repository.SponsorRepository
import com.example.core.model.Sponsor
import javax.inject.Inject

class GetSponsorsUseCase @Inject constructor(
    private val sponsorRepository: SponsorRepository
) {

    suspend operator fun invoke(): List<Sponsor> {
        return sponsorRepository
            .getSponsors()
            .sortedBy { it.grade.priority }
    }
}