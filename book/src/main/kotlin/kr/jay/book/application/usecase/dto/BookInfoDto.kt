package kr.jay.book.application.usecase.dto

import java.time.LocalDate

/**
 * BookInfoDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */
data class BookInfoDto(
    val title: String,
    val description: String,
    val author: String,
    val isbn: String,
    val publicationDate: LocalDate,
    val source: String,
    val classification: String,
    val location: String,
    )
