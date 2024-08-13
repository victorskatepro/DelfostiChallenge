package com.vsaico.delfostichallenge.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vsaico.delfostichallenge.databinding.ItemPlaceBinding
import com.vsaico.delfostichallenge.domain.model.Place

class PlaceHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPlaceBinding.bind(view)

    fun bind(place: Place) {
        with(binding) {
            tvName.text = place.title
            tvDescription.text = place.description
            Glide
                .with(itemView)
                .load(place.imageUrl)
                .into(ivPlace)
        }
    }
}