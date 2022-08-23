package com.udacity.shoestore.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes


    init {
        _shoes.value= mutableListOf()

    }



    fun addShoe(name: String, size: String, company: String, description: String) {
        _shoes.value?.add(Shoe(name, size, company, description))

    }

}