package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ui.viewmodels.ShoeViewModel

class ShoeDetailsFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var binding: FragmentShoeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.btnCancel.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeFragment)
        }
        binding.btnAdd.setOnClickListener {
            viewModel.addShoe(
                binding.inputShoeName.text.toString(),
                binding.inputSize.text.toString(),
                binding.inputCompany.text.toString(),
                binding.inputDescription.text.toString(),
            )

            this.findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeFragment)
        }

        return binding.root
    }


}