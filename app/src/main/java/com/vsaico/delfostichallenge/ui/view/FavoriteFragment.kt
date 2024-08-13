package com.vsaico.delfostichallenge.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vsaico.delfostichallenge.R
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.databinding.FragmentFavoriteBinding
import com.vsaico.delfostichallenge.ui.adapter.PlaceSavedAdapter
import com.vsaico.delfostichallenge.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate){

    private var placesSaved = mutableListOf<PlaceEntity>()

    private val adapter by lazy { PlaceSavedAdapter(placesSaved) }

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        favoriteViewModel.getMyPlaces()
    }

    private fun setAdapter() {
        binding.rvPlacesSaved.adapter = adapter
    }

    private fun observeViewModel() {
        favoriteViewModel.placesSaved.observe(this) {
            placesSaved.clear()
            placesSaved.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}