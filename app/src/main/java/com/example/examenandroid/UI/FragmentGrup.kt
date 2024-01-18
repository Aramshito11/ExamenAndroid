package com.example.examenandroid.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.VM.VMGrup
import com.example.examenandroid.databinding.FragmentGrupBinding


class FragmentGrup : Fragment() {

    private lateinit var binding: FragmentGrupBinding
    private lateinit var alumneViewModel: VMGrup
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grup, container, false
        )

        val llista = resources.getStringArray(R.array.AlumnesNotes)

        val spinner = binding.spinner

        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_item, llista)

        spinner.adapter = adapter

        if (spinner.selectedItem != null) {
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        requireContext(),
                        spinner.selectedItem.toString() + " ", Toast.LENGTH_SHORT
                    ).show()
                    if (spinner.selectedItem.toString() == "Aprovats") {
                        alumneViewModel.obtenirAprovats(requireContext())
                        alumneViewModel.alumne.observe(viewLifecycleOwner) { llistaAlumnes ->
                            binding.recyclerViewAlumnes.adapter = GrupAdapter(llistaAlumnes)
                        }
                    } else if (spinner.selectedItem.toString() == "Suspesos") {
                        alumneViewModel.obtenirSuspesos(requireContext())
                        alumneViewModel.alumne.observe(viewLifecycleOwner) { llistaAlumnes ->
                            binding.recyclerViewAlumnes.adapter = GrupAdapter(llistaAlumnes)
                        }
                    } else {
                        alumneViewModel.obtenirAlumnes(requireContext())
                        alumneViewModel.alumne.observe(viewLifecycleOwner) { llistaAlumnes ->
                            binding.recyclerViewAlumnes.adapter = GrupAdapter(llistaAlumnes)
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }


        alumneViewModel = ViewModelProvider(this).get(VMGrup::class.java)

        recyclerView = binding.recyclerViewAlumnes

        recyclerView.layoutManager = LinearLayoutManager(activity)


        return binding.root
    }



}
