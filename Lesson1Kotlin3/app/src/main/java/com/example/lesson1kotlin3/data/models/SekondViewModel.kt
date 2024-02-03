package com.example.lesson1kotlin3.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SekondViewModel : ViewModel(){
    private var _userData = MutableLiveData<UserModel>()
    val userData: LiveData<UserModel> = _userData

    fun updateUserModel(userModel: UserModel){
        _userData.value = userModel
    }
}