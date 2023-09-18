package com.catnip.solarsystem.presentation.planetlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.catnip.solarsystem.core.ViewHolderBinder
import com.catnip.solarsystem.databinding.ItemGridPlanetBinding
import com.catnip.solarsystem.databinding.ItemLinearPlanetBinding
import com.catnip.solarsystem.model.Planet

class PlanetListAdapter(
    val adapterLayoutMode: AdapterLayoutMode,
    private val onClickListener: (Planet) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {


    private val dataDiffer = AsyncListDiffer(this,object : DiffUtil.ItemCallback<Planet>(){
        override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
            return oldItem.position == newItem.position &&
                    oldItem.name == newItem.name &&
                    oldItem.velocity == newItem.velocity &&
                    oldItem.desc == newItem.desc &&
                    oldItem.distanceFromSun == newItem.distanceFromSun &&
                    oldItem.imgUrl == newItem.imgUrl
        }

        override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            AdapterLayoutMode.GRID.ordinal -> (
                    GridPlanetItemViewHolder(
                        binding = ItemGridPlanetBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false
                        ), onClickListener
                    )
                )

            else -> {
                LinearPlanetItemViewHolder(
                    binding = ItemLinearPlanetBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickListener
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return dataDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bind = (holder as ViewHolderBinder<Planet>).bind(dataDiffer.currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return adapterLayoutMode.ordinal
    }

    fun submitData(data: List<Planet>){
        dataDiffer.submitList(data)
    }

}