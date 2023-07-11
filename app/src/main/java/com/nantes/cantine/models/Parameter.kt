package com.nantes.cantine.models

data class Parameter (
    val dataset: String,
    val rows: Int,
    val start: Int,
    val sort: List<String>,
    val facet: List<String>,
    val format: String,
    val timezone: String,
        )