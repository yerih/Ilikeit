package com.plcoding.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.plcoding.graphqlcountriesapp.data.ApolloCountryService
import com.plcoding.graphqlcountriesapp.data.CountryDataSource
import com.plcoding.graphqlcountriesapp.usecases.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.usecases.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()


    @Provides
    @Singleton
    fun provideCountryDataSource(apolloClient: ApolloClient): CountryDataSource = ApolloCountryService(apolloClient)

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryDataSource: CountryDataSource): GetCountriesUseCase {
        return GetCountriesUseCase(countryDataSource)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryDataSource: CountryDataSource): GetCountryUseCase {
        return GetCountryUseCase(countryDataSource)
    }


}

