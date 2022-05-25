package com.dwinabela.modul5.network

import com.squareup.moshi.Json

data class Province(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)