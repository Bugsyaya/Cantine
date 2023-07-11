package com.nantes.cantine.models

data class Record (
    val datasetid: String,
    val recordid: String,
    val fields: Field,
    val record_timestamp: String,
        )