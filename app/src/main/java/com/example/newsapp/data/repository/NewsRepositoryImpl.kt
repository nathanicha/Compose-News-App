package com.example.newsapp.data.repository

import com.example.newsapp.data.model.Article
import com.example.newsapp.data.network.NewsApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService
) : NewsRepository {

    override fun getTopHeadlines() = flow {
        emit(listOf<Article>())
    }
//        emit(Result.loading()) // custom loading wrapper
//        val response = apiService.getTopHeadlines()
//        val articles = response.articles.map { dto ->
//            Article(
//                title = dto.title,
//                description = dto.description,
//                url = dto.url,
//                imageUrl = dto.urlToImage,
//                publishedAt = dto.publishedAt
//            )
//        }
//        emit(Result.success(articles))
//    }.catch { e ->
//        emit(Result.error<List<Article>>(e.localizedMessage ?: "Unknown Error"))
//    }
}