package com.udacity.shoestore.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    var size = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var description = MutableLiveData<String>()

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes


    init {
        _shoes.value = mutableListOf()

    }

    fun addShoe(name: String, size: String, company: String, description: String) {
        _shoes.value?.add(Shoe(name, size, company, description))
    }

}