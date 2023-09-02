package com.plcoding.graphqlcountriesapp.domain

data class Country(
    val name: String = "country name",
    val emoji: String = "emoji",
    val continent: Continent = Continent()
){
    data class Continent(val name: String = "continent name")
}

val countries = listOf(Country(), Country(), Country(), Country(), Country(), Country())

