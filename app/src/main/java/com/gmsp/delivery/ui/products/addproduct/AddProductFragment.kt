package com.gmsp.delivery.ui.products.addproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmsp.delivery.databinding.FragmentAddProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddProductFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var viewModel: AddProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }
}