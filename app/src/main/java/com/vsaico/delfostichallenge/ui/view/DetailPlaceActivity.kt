package com.vsaico.delfostichallenge.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.vsaico.delfostichallenge.R
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.databinding.ActivityDetailPlaceBinding
import com.vsaico.delfostichallenge.databinding.ActivitySplashActivitiyBinding
import com.vsaico.delfostichallenge.ui.viewmodel.DetailPlaceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPlaceActivity : BaseActivity<ActivityDetailPlaceBinding>(ActivityDetailPlaceBinding::inflate), OnMapReadyCallback {

    private val detailPlaceViewModel: DetailPlaceViewModel by viewModels()

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val idPlace = intent.extras?.getInt("idPlace")

        idPlace?.let {
            detailPlaceViewModel.getPlaceSavedFromId(it)
        }

        detailPlaceViewModel.placeEntity.observe(this) {
            showInformationPlace(it)
        }
    }

    private fun showInformationPlace(placeEntity: PlaceEntity) {
        with(binding) {
            placeTitle.text = placeEntity.title
            placeDescription.text = placeEntity.description
            placeAddress.text = placeEntity.address
            Glide
                .with(this@DetailPlaceActivity)
                .load(placeEntity.imageUrl)
                .into(placeImage)
        }
        val position = LatLng(placeEntity.latitude, placeEntity.longitude)
        mMap.addMarker(MarkerOptions().position(position))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        mMap.animateCamera(CameraUpdateFactory.zoomTo( 17.0f))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

    }
}