package com.example.vahid.data.di

import com.example.vahid.data.BookRepositoryImpl
import com.example.vahid.domain.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindRepository(bookRepositoryImpl: BookRepositoryImpl): BookRepository
}