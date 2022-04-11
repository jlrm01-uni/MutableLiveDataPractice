package com.example.mutablelivedatapractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestModel: ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData("default value")
    val count: MutableLiveData<Int> = MutableLiveData(0)
}