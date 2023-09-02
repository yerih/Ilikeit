package com.plcoding.graphqlcountriesapp.data

import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.domain.Result

interface CountryDataSource{
    suspend fun getCountries(): Result<List<Country>>
    suspend fun getCountry(code: String): Result<Country>
}