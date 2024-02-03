package com.example.lesson1kotlin3.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson1kotlin3.R
import com.example.lesson1kotlin3.databinding.FragmentRegistrationBinding
import com.example.lesson1kotlin3.ui.views.preferens.SharedPreferens


class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() = with(binding) {
        val preference = SharedPreferens(requireActivity())
        btnReg.setOnClickListener {
            preference.user_name = edName.text.toString().trim()
            preference.age = edAge.text.toString().trim()
            preference.user_email = edEmail.text.toString().trim()
            preference.user_password = edRassword.text.toString().trim()
            preference.isShowRegister = true
            findNavController().navigate(R.id.action_registrationFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
