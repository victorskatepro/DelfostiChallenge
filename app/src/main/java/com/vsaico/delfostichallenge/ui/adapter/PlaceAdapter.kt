package com.vsaico.delfostichallenge.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vsaico.delfostichallenge.R
import com.vsaico.delfostichallenge.domain.model.Place
import com.vsaico.delfostichallenge.ui.holder.PlaceHolder
import com.vsaico.delfostichallenge.util.inflate

class PlaceAdapter(
    var places: List<Place>
) : RecyclerView.Adapter<PlaceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view = parent.inflate(R.layout.item_place)
        return PlaceHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        val itemPlace = places[position]
        holder.bind(itemPlace)
    }

    override fun getItemCount(): Int = places.size
}