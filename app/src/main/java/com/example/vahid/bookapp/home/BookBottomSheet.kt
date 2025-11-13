package com.example.vahid.bookapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.vahid.bookapp.R
import com.example.vahid.domain.model.BookModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookBottomSheet(book: BookModel?, onDismissRequest: () -> Unit) {

    if (book != null) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(width = 160.dp, height = 240.dp)
                        .align(Alignment.CenterHorizontally),
                    model = book.cover,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    error = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null
                )
                Text(text = "Title:   ${book.title}")
                Text(text = "Author:   ${book.author}")
                Text(text = "Publish Year:   ${book.publishYear}")
            }
        }
    }

}