package com.example.vahid.domain

import com.example.vahid.domain.model.BookModel
import com.example.vahid.domain.model.Result
import io.reactivex.rxjava3.core.Single

interface BookRepository {
    fun getBooks(): Single<Result<List<BookModel>>>
}