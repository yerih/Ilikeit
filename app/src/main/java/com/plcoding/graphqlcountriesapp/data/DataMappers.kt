package com.plcoding.graphqlcountriesapp.data

import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.domain.Country

fun CountriesQuery.Country.toDomain() = Country(name, emoji, Country.Continent(continent.name))
fun List<CountriesQuery.Country>.toDomain() = map{ Country(it.name, it.emoji, Country.Continent(it.continent.name)) }

fun CountryQuery.Country.toDomain() = Country(name, emoji, Country.Continent(continent.name))


