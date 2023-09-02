package com.plcoding.graphqlcountriesapp.usecases

import com.plcoding.graphqlcountriesapp.data.CountryDataSource
import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.domain.Result

class GetCountryUseCase (
    private val repo: CountryDataSource
){
    suspend fun execute(code: String): Result<Country> = repo.getCountry(code)
}

