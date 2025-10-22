package com.example.newsapp.data.repository

import com.example.newsapp.data.network.NewsApiService
import com.example.newsapp.domain.model.ApiResult
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService
) : NewsRepository {

    override fun getTopHeadlines(): Flow<ApiResult<List<Article>?>> = flow {
        emit(ApiResult.Loading) // custom loading wrapper
        val response = apiService.getTopHeadlines()
        val articles = response.articles
            ?.mapNotNull { dto ->
                dto.title?.let {
                    Article(
                        title = it,
                        description = dto.description,
                        url = dto.url,
                        imageUrl = dto.urlToImage,
                        publishedAt = dto.publishedAt
                    )
                }
            }
        emit(ApiResult.Success(articles))
    }.catch { e ->
        when (e) {
            is HttpException -> {
                val code = e.code()               // <-- HTTP status code
                val errorBody = e.response()?.errorBody()?.string()  // optional
                emit(ApiResult.Error("HTTP $code: $errorBody", code.toString()))
            }

            is IOException -> {
                emit(ApiResult.Error("Network error, please check connection", null))
            }

            else -> {
                emit(ApiResult.Error(e.localizedMessage ?: "Unknown error", null))
            }
        }
    }
}