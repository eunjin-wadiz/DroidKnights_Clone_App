package com.example.core.data.di

import com.example.core.data.api.GithubRawApi
import com.example.core.data.repository.DefaultSponsorRepository
import com.example.core.data.repository.SponsorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataModule {

    @InstallIn(SingletonComponent::class)
    @Module
    internal object FakeModule {

        @Provides
        @Singleton
        fun provideSponsorRepository(
            githubRawApi: GithubRawApi
        ): SponsorRepository = DefaultSponsorRepository(githubRawApi)
    }
}