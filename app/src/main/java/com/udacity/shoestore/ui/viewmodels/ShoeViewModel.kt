package com.udacity.shoestore.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()


    var shoeName = ""
    var shoeSize = ""
    var company = ""
    var description = ""

}