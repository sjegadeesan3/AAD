package com.jegadeesan.data

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class MainTopic (
    val mainTopicName: String = "",
    val uniqueId: String = ""
): Serializable

@Keep
data class SubTopic (
    val subTopicName: String = "",
    val uniqueId: String = ""
): Serializable