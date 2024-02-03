package com.example.lesson1kotlin3.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lesson1kotlin3.R
import com.example.lesson1kotlin3.data.models.SekondViewModel
import com.example.lesson1kotlin3.data.models.UserModel
import com.example.lesson1kotlin3.databinding.FragmentSekondBinding
import com.example.lesson1kotlin3.ui.views.preferens.SharedPreferens


class SecondFragment : Fragment() {

    private var _binding: FragmentSekondBinding? = null
    private val binding: FragmentSekondBinding get() = _binding!!
    private val secondViewModel: SekondViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSekondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
    }

    private fun initialize() {
        val preferenceHelper = SharedPreferens(requireActivity())
        secondViewModel.updateUserModel(
            UserModel(
                preferenceHelper.user_name!!,
                preferenceHelper.age!!,
                preferenceHelper.user_email!!,
                preferenceHelper.user_password!!
            )
        )
    }

    private fun setupObserver() = with(binding) {
        secondViewModel.userData.observe(viewLifecycleOwner) { it ->
        }
        btnSekond.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}