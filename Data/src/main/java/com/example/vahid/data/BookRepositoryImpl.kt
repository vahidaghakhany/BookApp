package com.example.vahid.data

import com.example.vahid.data.datasource.BookDataSource
import com.example.vahid.data.dto.mapper.mapErrorMessage
import com.example.vahid.data.dto.mapper.toDomainModel
import com.example.vahid.domain.BookRepository
import com.example.vahid.domain.model.BookModel
import com.example.vahid.domain.model.Result
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val remoteDataSource: BookDataSource
) : BookRepository {

    override fun getBooks(): Single<Result<List<BookModel>>> {
        return remoteDataSource.getBooks()
            .map<Result<List<BookModel>>> {
                Result.Success(it.toDomainModel())
            }
            .onErrorReturn {
                Result.Error(mapErrorMessage(it))
            }

    }
}