package com.example.newsapp.data.repository

import com.example.newsapp.domain.model.ApiResult
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopHeadlines(): Flow<ApiResult<List<Article>?>>
}