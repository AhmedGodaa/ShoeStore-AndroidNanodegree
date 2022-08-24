package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.ui.viewmodels.ShoeViewModel


class ShoeFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var binding: FragmentShoeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe, container, false)

        binding.btnAddShoe.setOnClickListener {

            it.findNavController().navigate(R.id.action_shoeFragment_to_shoeDetailsFragment)

        }

        viewModel.shoes.observe(
            this as LifecycleOwner,
            Observer {
                for (shoe in viewModel.shoes.value!!) {
                    val shoeBinding = ShoeItemBinding.inflate(layoutInflater)
                    shoeBinding.itemName.text = shoe.name
                    shoeBinding.itemSize.text = shoe.size
                    shoeBinding.itemCompany.text = shoe.company
                    shoeBinding.itemDescription.text = shoe.description

                    binding.shoeContainer.addView(shoeBinding.root)
                }

            })
        setHasOptionsMenu(true)

        return binding.root
    }


}