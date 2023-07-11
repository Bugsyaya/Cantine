package com.nantes.cantine.models

data class Menu (
    val nhits: Int,
    val parameters: List<Parameter>,
    val records: List<Record>,
)