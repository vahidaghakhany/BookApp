package com.example.vahid.domain.usecase

import com.example.vahid.domain.BookRepository
import com.example.vahid.domain.model.BookModel
import com.example.vahid.domain.model.Result
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke(): Single<Result<List<BookModel>>> {
        return repository.getBooks()
    }
}