package com.jegadeesan.module

import com.jegadeesan.viewmodel.MainTopicViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val aadModule = module {
    viewModel { MainTopicViewModel() }
}