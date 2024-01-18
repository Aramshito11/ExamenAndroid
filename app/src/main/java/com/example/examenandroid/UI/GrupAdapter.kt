package com.example.examenandroid.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.databinding.RecicleviewBinding
import com.example.examenandroid.model.Alumne

class GrupAdapter (private val alumneList:List<Alumne>) : RecyclerView.Adapter<AlumneViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumneViewHolder {
        val layoutInflater = RecicleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlumneViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = alumneList.size

    override fun onBindViewHolder(holder: AlumneViewHolder, position: Int) {
        val item = alumneList[position]
        holder.render(item)
    }

}

class AlumneViewHolder(private var binding: RecicleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(alumne: Alumne){
        binding.textViewNom.text = alumne.group
        binding.textViewGrup.text = alumne.name
        binding.textViewNota.text = alumne.note.toString()
    }
}