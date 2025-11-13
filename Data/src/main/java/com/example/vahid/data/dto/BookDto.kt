package com.example.vahid.data.dto

import com.google.gson.annotations.SerializedName

data class BookDto(
    @SerializedName("reading_log_entries") val logEntry: List<LogEntryDto>?
)

data class LogEntryDto(
    val work: WorkDto?
)

data class WorkDto(
    val title: String?,
    @SerializedName("author_names") val author: List<String>?,
    @SerializedName("first_publish_year") val publishYear: Int?,
    @SerializedName("cover_id") val coverId: Long?
)
