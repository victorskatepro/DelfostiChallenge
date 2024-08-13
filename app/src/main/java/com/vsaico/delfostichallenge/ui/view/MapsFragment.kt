package com.vsaico.delfostichallenge.ui.view

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.vsaico.delfostichallenge.R
import com.vsaico.delfostichallenge.ui.viewmodel.MapsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : Fragment() {

    private var mMap: GoogleMap? = null
    private val mapsViewModel: MapsViewModel by viewModels()

    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
        updateMarkers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        observeViewModel()
    }

    private fun observeViewModel() {
        mapsViewModel.places.observe(viewLifecycleOwner) { places ->
            if (mMap != null) {
                updateMarkers()
            }
        }
    }

    private fun updateMarkers() {
        mMap?.let { map ->
            mapsViewModel.places.value?.forEach { place ->
                val latLng = LatLng(place.latitude, place.longitude)
                map.addMarker(MarkerOptions().position(latLng).title(place.title))
            }
            val lastPlace = mapsViewModel.places.value?.lastOrNull()
            lastPlace?.let {
                val latLngCamera = LatLng(it.latitude, it.longitude)
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngCamera))
                map.animateCamera(CameraUpdateFactory.zoomTo(10.0f))
            }
        }
    }
}