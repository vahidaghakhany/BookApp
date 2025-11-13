package com.example.vahid.data.dto.mapper

import com.example.vahid.data.dto.BookDto
import com.example.vahid.domain.model.BookModel
import com.example.vahid.domain.model.Result

fun BookDto.toDomainModel(): List<BookModel> {
    return this.logEntry?.map {
        BookModel(
            title = it.work?.title ?: "",
            author = it.work?.author?.joinToString(", ") ?: "",
            cover =  it.work?.coverId?.let { "https://covers.openlibrary.org/b/id/$it-M.jpg" } ?: "",
            publishYear = it.work?.publishYear.toString(),
        )
    } ?: emptyList()
}