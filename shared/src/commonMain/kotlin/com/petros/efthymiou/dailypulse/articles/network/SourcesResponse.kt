package com.petros.efthymiou.dailypulse.articles.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse(
    @SerialName("status")
    val status:String,
    @SerialName("sources")
    val source: List<Source>
)

@Serializable
data class Source(
    @SerialName("name")
    val name: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("language")
    val language: String?
)


data class SourceAfterNetwork(
    val name: String?,
    val desc: String?,
    val language:String?
)