package com.example.vahid.bookapp.home

import androidx.lifecycle.ViewModel
import com.example.vahid.domain.model.Result
import com.example.vahid.domain.usecase.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    private var compositeDisposable = CompositeDisposable()

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        _uiState.update { it.copy(isLoading = true) }
        compositeDisposable.add(
            getBooksUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    when (result) {
                        is Result.Success -> _uiState.update {
                            it.copy(
                                books = result.data,
                                isLoading = false
                            )
                        }

                        is Result.Error -> _uiState.update {
                            it.copy(
                                showError = result.message,
                                isLoading = false
                            )
                        }
                    }
                }
        )
    }

    fun clearError() {
        _uiState.update { it.copy(showError = "") }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}