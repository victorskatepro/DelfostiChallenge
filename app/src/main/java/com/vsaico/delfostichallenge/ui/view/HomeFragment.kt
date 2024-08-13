package com.vsaico.delfostichallenge.ui.view

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vsaico.delfostichallenge.databinding.FragmentHomeBinding
import com.vsaico.delfostichallenge.domain.model.Place
import com.vsaico.delfostichallenge.ui.adapter.PlaceAdapter
import com.vsaico.delfostichallenge.ui.viewmodel.HomeViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.Duration
import com.yuyakaido.android.cardstackview.RewindAnimationSetting
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    CardStackListener {

    private val homeViewModel: HomeViewModel by viewModels()

    private var listPlace: List<Place> = emptyList()

    private val manager by lazy { CardStackLayoutManager(context, this) }

    private val adapter by lazy { PlaceAdapter(listPlace) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instanceCard()
        observeValues()
        observeButtons()
    }

    private fun observeValues() {
        homeViewModel.places.observe(this) {
            adapter.places = it
            adapter.notifyDataSetChanged()
            showButtons()
        }
        homeViewModel.isLoading.observe(this) {
            binding.progressBar.isVisible = it
        }
    }

    private fun observeButtons() {
        binding.btnLike.setOnClickListener {
            // Like
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.rvPlaces.swipe()
        }

        binding.btnSkip.setOnClickListener {
            // Skip
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.rvPlaces.swipe()
        }

        binding.btnRewind.setOnClickListener {
            // Rewind
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            binding.rvPlaces.rewind()
        }
    }

    private fun showButtons() {
        binding.btnLike.isVisible = true
        binding.btnSkip.isVisible = true
        binding.btnRewind.isVisible = true
    }

    private fun instanceCard() {
        binding.rvPlaces.adapter = adapter
        binding.rvPlaces.layoutManager = manager
    }



    override fun onCardDragging(direction: Direction?, ratio: Float) {
        //TODO("Not yet implemented")
    }

    override fun onCardSwiped(direction: Direction?) {
        if (direction == Direction.Right) {
            val place = adapter.places[manager.topPosition - 1]
            homeViewModel.savePlace(place)
        }
    }

    override fun onCardRewound() {
        //TODO("Not yet implemented")
    }

    override fun onCardCanceled() {
        //TODO("Not yet implemented")
    }

    override fun onCardAppeared(view: View?, position: Int) {
        //TODO("Not yet implemented")
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        //TODO("Not yet implemented")
    }

}