package com.jegadeesan.module

import com.google.gson.Gson
import com.jegadeesan.utils.FileUtil
import com.jegadeesan.viewmodel.MainTopicViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val aadModule = module {
    viewModel { MainTopicViewModel() }

    single { Gson() }
    single { FileUtil(androidApplication()) }
}