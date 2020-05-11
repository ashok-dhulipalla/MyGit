package com.example.mvvmdemo

import androidx.lifecycle.MutableLiveData

class ViewModelDemo {

    val liveData = MutableLiveData<String>().apply { postValue("initial value")}

    fun postLiveData(str:String){
        System.out.println(".......................==============================")
        liveData.postValue(str)
    }
}