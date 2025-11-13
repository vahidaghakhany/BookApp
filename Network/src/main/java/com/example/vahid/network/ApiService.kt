package com.example.vahid.network

import com.example.vahid.data.dto.BookDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.adapter.rxjava3.Result
import retrofit2.http.GET

interface ApiService {

    @GET("people/mekBot/books/want-to-read.json")
    fun getBooks(): Single<BookDto>

}