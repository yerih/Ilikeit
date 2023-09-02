package com.plcoding.graphqlcountriesapp.domain

class Result<T>(
    val value: T?,
    val error: Error? = null,
){
    fun isValid(): Boolean = (value != null)
    fun isError(): Boolean = (error != null)
}