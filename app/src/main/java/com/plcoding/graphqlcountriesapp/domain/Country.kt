package com.plcoding.graphqlcountriesapp.domain

data class Country(
    val name: String = "",
    val emoji: String = "",
    val continent: Continent = Continent()
){
    data class Continent(val name: String = "")
}