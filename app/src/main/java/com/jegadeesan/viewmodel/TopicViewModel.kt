package com.jegadeesan.viewmodel

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jegadeesan.data.MainTopic
import com.jegadeesan.data.SubTopic
import com.jegadeesan.repo.data.AadTopics
import com.jegadeesan.utils.FileUtil
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TopicViewModel : ViewModel(), KoinComponent {

    private val gson: Gson by inject()
    private val fileUtil: FileUtil by inject()

    fun getMainTopics(): List<MainTopic> {
        val list = arrayListOf<MainTopic>()
        getAadTopics()?.mainTopics?.forEach { topic ->
            list.add(MainTopic(mainTopicName = topic.name, uniqueId = topic.uniqueId))
        }
        return list
    }

    private fun getAadTopics(): AadTopics? {
        return try {
            gson.fromJson(fileUtil.loadJSONFromAsset(AAD_TOPICS_JSON_FILE), AadTopics::class.java)
        } catch (e: Exception) {
            null
        }
    }

    fun getSubTopics(uniqueId: String?): List<SubTopic> {
        if(uniqueId == null) {
            return emptyList()
        }
        getAadTopics()?.mainTopics?.forEach { topic ->
            if(topic.uniqueId == uniqueId) {
                return convertSubTopicsList(topic.subTopics)
            }
        }
        return emptyList()
    }

    private fun convertSubTopicsList(subTopics: List<com.jegadeesan.repo.data.SubTopic>): List<SubTopic> {
        val subTopicsList = arrayListOf<SubTopic>()

        subTopics.forEach {
            subTopicsList.add(SubTopic(it.name, it.uniqueId))
        }
        return subTopicsList
    }

    companion object {
        private const val AAD_TOPICS_JSON_FILE = "AADTopics.json"
    }
}