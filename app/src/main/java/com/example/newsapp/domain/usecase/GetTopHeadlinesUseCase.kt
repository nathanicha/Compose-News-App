package com.example.newsapp.domain.usecase

import com.example.newsapp.data.repository.NewsRepository

class GetTopHeadlinesUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke() = repository.getTopHeadlines()
}