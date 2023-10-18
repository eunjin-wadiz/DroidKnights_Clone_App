package com.example.core.data.mapper

import com.example.core.data.api.model.SponsorResponse
import com.example.core.model.Sponsor

internal fun SponsorResponse.toData(): Sponsor = Sponsor(
    name = name,
    imageUrl = imageUrl,
    homepage = homepage,
    grade = when (grade) {
        SponsorResponse.Grade.PLATINUM -> Sponsor.Grade.PLATINUM
        SponsorResponse.Grade.GOLD -> Sponsor.Grade.GOLD
    }
)