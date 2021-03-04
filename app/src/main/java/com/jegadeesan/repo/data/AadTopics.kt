package com.jegadeesan.repo.data

import androidx.annotation.Keep

@Keep
data class AadTopics (
    var mainTopics: List<Topic>
)

@Keep
data class Topic(
    val id: Int,
    val name: String,
    val uniqueId: String,
    val subTopics: List<SubTopic>
)

@Keep
data class SubTopic(
    val id: Int,
    val name: String
)