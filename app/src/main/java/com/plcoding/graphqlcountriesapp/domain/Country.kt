package com.plcoding.graphqlcountriesapp.domain

data class Country(
    val name: String = "Loading...",
    val emoji: String = "Loading...",
    val continent: Continent = Continent()
){
    data class Continent(val name: String = "Loading...")
}

val countries = listOf(Country(), Country(), Country(), Country(), Country(), Country())

