package com.example.vahid.network.di

import com.example.vahid.data.datasource.BookDataSource
import com.example.vahid.network.ApiService
import com.example.vahid.network.BookRemoteDataSourceImpl
import com.example.vahid.network.BuildConfig
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    companion object {

        @Singleton
        @Provides
        fun provideApiService(): ApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

            val gson = GsonBuilder()
                .setStrictness(Strictness.LENIENT)
                .create()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.REST_API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build().create(ApiService::class.java)
        }

    }

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(bookRemoteDataSourceImpl: BookRemoteDataSourceImpl): BookDataSource

}