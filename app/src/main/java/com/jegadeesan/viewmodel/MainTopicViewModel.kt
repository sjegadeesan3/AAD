package com.jegadeesan.viewmodel

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jegadeesan.data.MainTopic
import com.jegadeesan.repo.data.AadTopics
import com.jegadeesan.utils.FileUtil
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainTopicViewModel : ViewModel(), KoinComponent {

    private val gson: Gson by inject()
    private val fileUtil: FileUtil by inject()
    private val AAD_TOPICS_JSON_FILE = "AADTopics.json"

    fun getMainTopics(): List<MainTopic> {
        val aadTopics = try {
            gson.fromJson(
                fileUtil.loadJSONFromAsset(AAD_TOPICS_JSON_FILE),
                AadTopics::class.java
            )
        } catch (e: Exception) {
            null
        }
        val list = arrayListOf<MainTopic>()
        aadTopics?.mainTopics?.forEach { topic ->
            list.add(MainTopic(topic.id, topic.name))
        }
        return list
    }
}