package com.catnip.solarsystem.presentation.planetlist.adapter

import android.content.DialogInterface.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import coil.load
import com.catnip.solarsystem.core.ViewHolderBinder
import com.catnip.solarsystem.databinding.ItemGridPlanetBinding
import com.catnip.solarsystem.databinding.ItemLinearPlanetBinding
import com.catnip.solarsystem.model.Planet

class LinearPlanetItemViewHolder(
    private val binding: ItemLinearPlanetBinding,
    private val onClickListener: (Planet) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Planet>{
    override fun bind(item: Planet) {
        binding.ivPlanet.load(item.imgUrl){
            crossfade(true)
        }
        binding.tvPlanetName.text = item.name
        binding.root.setOnClickListener{
            onClickListener.invoke(item)
        }
    }
}

class GridPlanetItemViewHolder(
    private val binding: ItemGridPlanetBinding,
    private val onClickListener: (Planet) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Planet>{
    override fun bind(item: Planet) {
        binding.ivPlanet.load(item.imgUrl){
            crossfade(true)
        }
        binding.tvPlanetName.text = item.name
        binding.root.setOnClickListener{
            onClickListener.invoke(item)
        }
    }
}

