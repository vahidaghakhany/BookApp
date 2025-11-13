package com.example.vahid.data.datasource

import com.example.vahid.data.dto.BookDto
import io.reactivex.rxjava3.core.Single

interface BookDataSource {

    fun getBooks(): Single<BookDto>

}