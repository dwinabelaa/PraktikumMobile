package com.dwinabela.modul5.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Url

private const val BASE_URL = "https://www.emsifa.com/api-wilayah-indonesia/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ProvinsiServiceApi{
    @GET("provinces.json")
    suspend fun getData() :List<Province>
    @GET
    suspend fun getDataBaru(@Url url: String) : List<Province>
}
object ProvinsiApi{
    val retrofitServiceApi : ProvinsiServiceApi by lazy {
        retrofit.create(ProvinsiServiceApi::class.java)
    }
}