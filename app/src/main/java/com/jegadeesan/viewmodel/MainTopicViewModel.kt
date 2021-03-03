package com.jegadeesan.viewmodel

import androidx.lifecycle.ViewModel
import com.jegadeesan.data.MainTopic

class MainTopicViewModel : ViewModel(){

    fun getMainTopics(): List<MainTopic> {
        val list = arrayListOf<MainTopic>()
        list.add(MainTopic(1, "Android core"))
        list.add(MainTopic(2, "User interface"))
        list.add(MainTopic(3, "Data management"))
        list.add(MainTopic(4, "Debugging"))
        list.add(MainTopic(5, "Testing"))
        return list
    }
}