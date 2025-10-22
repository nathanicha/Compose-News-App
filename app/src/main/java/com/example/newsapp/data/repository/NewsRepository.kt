package com.example.newsapp.data.repository

import com.example.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopHeadlines(): Flow<List<Article>>
}