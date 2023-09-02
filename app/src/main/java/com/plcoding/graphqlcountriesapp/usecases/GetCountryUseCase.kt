package com.plcoding.graphqlcountriesapp.usecases

import com.plcoding.graphqlcountriesapp.data.CountryDataSource
import com.plcoding.graphqlcountriesapp.domain.Country

class GetCountriesUseCase (
    private val repo: CountryDataSource
){
    suspend fun execute(): List<Country> = repo.getCountries().sortedBy { it.name }
}

