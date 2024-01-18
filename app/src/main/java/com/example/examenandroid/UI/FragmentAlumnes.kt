package com.example.examenandroid.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.examenandroid.R
import com.example.examenandroid.VM.VMAlumnes
import com.example.examenandroid.databinding.FragmentAlumnesBinding


class FragmentAlumnes : Fragment() {

    private lateinit var binding: FragmentAlumnesBinding
    private lateinit var mobleViewModel: VMAlumnes

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_alumnes, container, false
        )

        mobleViewModel = ViewModelProvider(this).get(VMAlumnes::class.java)

        binding.button.setOnClickListener {

            val nom= binding.editTextText.text.toString()
            val grup= binding.editTextText2.text.toString()
            val nota =binding.editTextText3.text.toString().toInt()


            mobleViewModel.afegirMoble(requireContext(), nom, grup, nota)
        }


        return binding.root
    }


}