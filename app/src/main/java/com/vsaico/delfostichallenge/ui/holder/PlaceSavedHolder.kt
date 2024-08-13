package com.vsaico.delfostichallenge.ui.holder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.databinding.ItemPlaceSavedBinding
import com.vsaico.delfostichallenge.ui.view.DetailPlaceActivity

class PlaceSavedHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemPlaceSavedBinding.bind(view)

    fun bind(placeEntity: PlaceEntity) {
        with(binding) {
            tvTitle.text = placeEntity.title
            Glide
                .with(itemView)
                .load(placeEntity.imageUrl)
                .circleCrop()
                .into(ivPlace)
        }
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailPlaceActivity::class.java)
            intent.putExtra("idPlace", placeEntity.id)
            itemView.context.startActivity(intent)
        }
    }
}