package com.example.s205420__lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.s205420__lykkehjulet.databinding.FragmentLostBinding
import com.example.s205420__lykkehjulet.databinding.FragmentFirstBinding


class lostFragment : Fragment() {

        private var _binding: FragmentLostBinding? = null
        private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLostBinding.inflate(inflater, container, false)
        return binding.root

    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val button2: Button = binding.buttonLost
            val text: TextView = binding.youLost
            button2.setOnClickListener{
                findNavController().navigate(R.id.action_blankFragment_to_SecondFragment)
            }
            text.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
