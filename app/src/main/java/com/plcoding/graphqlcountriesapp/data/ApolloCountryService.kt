package com.plcoding.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.domain.Result

class ApolloCountryService (
    private val client: ApolloClient
): CountryDataSource{
    override suspend fun getCountries(): Result<List<Country>> {
        val response = client.query(CountriesQuery()).execute()
        return response.data?.let{
            Result(it.countries.sortedBy { c -> c.name }.toDomain())
        } ?: Result(error = Error(response.errors!![0].message), value = null)
    }

    override suspend fun getCountry(code: String): Result<Country> {
        val response = client.query(CountryQuery(code)).execute()
        return if(response.errors.isNullOrEmpty())
            Result(response.data!!.country!!.toDomain())
        else
            Result(error = Error(response.errors!![0].message), value = null)
    }

}