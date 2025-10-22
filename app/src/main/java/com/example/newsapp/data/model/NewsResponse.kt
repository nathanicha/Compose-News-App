package com.example.newsapp.data.model

import com.google.gson.annotations.SerializedName


data class NewsResponse(
    @SerializedName("articles") val articles: List<ArticleResponse>? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("totalResults") val totalResults: Int? = null
)

data class ArticleResponse(
    @SerializedName("author") val author: String? = null,
    @SerializedName("content") val content: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("publishedAt") val publishedAt: String? = null,
    @SerializedName("source") val source: SourceResponse? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("urlToImage") val urlToImage: String? = null
)

data class SourceResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null
)