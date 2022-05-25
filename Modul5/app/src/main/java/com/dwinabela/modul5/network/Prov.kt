package com.dwinabela.modul5.network

import com.squareup.moshi.Json

data class Provinsi(
    @Json(name = "id")
    val id: Int,
    @Json(name = "nama")
    val nama: String
)