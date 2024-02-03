package com.example.lesson1kotlin3.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson1kotlin3.R
import com.example.lesson1kotlin3.databinding.FragmentThirdBinding
import com.example.lesson1kotlin3.ui.views.preferens.SharedPreferens

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()

    }

    private fun setupListener() = with(binding) {
        val preference = SharedPreferens(requireActivity())
        binding.btnThird.setOnClickListener {
            preference.user_name = edThirdName.text.toString().trim()
            preference.age = edThirdAge.text.toString().trim()
            preference.user_email = edThirdEmail.text.toString().trim()
            preference.user_password = edThirdRassword.text.toString().trim()
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}