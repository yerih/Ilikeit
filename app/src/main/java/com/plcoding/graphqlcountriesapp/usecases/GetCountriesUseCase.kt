package com.plcoding.graphqlcountriesapp.usecases

import com.plcoding.graphqlcountriesapp.data.CountryDataSource
import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.domain.Result

class GetCountriesUseCase (
    private val repo: CountryDataSource
){
    suspend fun execute(): Result<List<Country>> = repo.getCountries()
}

