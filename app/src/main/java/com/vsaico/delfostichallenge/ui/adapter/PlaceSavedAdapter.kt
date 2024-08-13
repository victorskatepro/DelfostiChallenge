package com.vsaico.delfostichallenge.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vsaico.delfostichallenge.R
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.ui.holder.PlaceSavedHolder
import com.vsaico.delfostichallenge.util.inflate

class PlaceSavedAdapter(
    val placeSavedList: List<PlaceEntity>
) : RecyclerView.Adapter<PlaceSavedHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceSavedHolder {
        val view = parent.inflate(R.layout.item_place_saved)
        return PlaceSavedHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceSavedHolder, position: Int) {
        val item = placeSavedList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = placeSavedList.size
}