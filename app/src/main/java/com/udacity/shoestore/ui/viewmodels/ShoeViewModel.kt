package com.udacity.shoestore.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoes


    fun addShoe(name: String, size: Int, company: String, description: String) {
        val shoe = Shoe(name = name, size = size, company = company, description = description)
        _shoes.value!!.add(shoe)
    }
}