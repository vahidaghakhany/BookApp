package com.example.vahid.network

import com.example.vahid.data.datasource.BookDataSource
import com.example.vahid.data.dto.BookDto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : BookDataSource {

    override fun getBooks(): Single<BookDto> {
        return apiService.getBooks()
    }

}