package com.example.vahid.bookapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import com.example.vahid.bookapp.R
import com.example.vahid.bookapp.ui.theme.BookAppTheme
import com.example.vahid.domain.model.BookModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState = HomeUiState(),
    onDismissError: () -> Unit = {},
) {

    var selectedItem by remember { mutableStateOf<BookModel?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book App") },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.Gray)
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(uiState.books) { item ->
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable {
                            selectedItem = item
                        }) {
                    AsyncImage(
                        modifier = Modifier.size(width = 90.dp, height = 140.dp),
                        model = item.cover,
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        error = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = null
                    )

                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(text = "Title:   ${item.title}")
                        Text(text = "Author:   ${item.author}")
                    }
                }
                HorizontalDivider()
            }

        }
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    if (uiState.showError.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = onDismissError,
            confirmButton = {
                TextButton(onClick = onDismissError) {
                    Text("OK")
                }
            },
            text = {
                Text(uiState.showError)
            }
        )
    }

    BookBottomSheet(selectedItem) {
        selectedItem = null
    }
}


data class HomeUiState(
    val books: List<BookModel> = emptyList(),
    val isLoading: Boolean = false,
    val showError: String = "",
)


@Preview
@Composable
private fun Preview() {
    BookAppTheme {
        HomeScreen(
            uiState = HomeUiState(
                books = listOf(
                    BookModel(
                        title = "Book1",
                        author = "Name",
                        cover = "",
                        publishYear = "1995"
                    ),
                    BookModel(
                        title = "Book2",
                        author = "Name",
                        cover = "",
                        publishYear = "1995"
                    ),
                    BookModel(
                        title = "Book3",
                        author = "Name",
                        cover = "",
                        publishYear = "1995"
                    )
                ),
            )
        )
    }
}