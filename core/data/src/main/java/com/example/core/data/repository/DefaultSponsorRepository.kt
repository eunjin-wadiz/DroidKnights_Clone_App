package com.example.core.data.repository

import com.example.core.data.api.GithubRawApi
import com.example.core.data.mapper.toData
import com.example.core.model.Sponsor
import javax.inject.Inject

internal class DefaultSponsorRepository @Inject constructor(
    private val githubRawApi: GithubRawApi
): SponsorRepository {

    override suspend fun getSponsors(): List<Sponsor> {
        return githubRawApi.getSponsors().map { it.toData() }
    }
}