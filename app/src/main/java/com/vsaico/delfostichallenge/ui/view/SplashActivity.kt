package com.vsaico.delfostichallenge.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.BuildConfig
import com.rommansabbir.animationx.Zoom
import com.rommansabbir.animationx.animationXZoom
import com.vsaico.delfostichallenge.R
import com.vsaico.delfostichallenge.data.firebase.RemoteConfigs
import com.vsaico.delfostichallenge.databinding.ActivitySplashActivitiyBinding
import com.vsaico.delfostichallenge.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashActivitiyBinding>(ActivitySplashActivitiyBinding::inflate) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashy()
        setEnvironment()
        observeViewModel()
    }

    private fun observeViewModel() {
        splashViewModel.showUnderMaintenance.observe(this) {
            Toast.makeText(this, "Under Maintenance", Toast.LENGTH_SHORT).show()
        }
        splashViewModel.showAnimationEnd.observe(this) {
            binding.ivLogo.animationXZoom(
                Zoom.ZOOM_OUT,
                duration = 1500
            )
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
            }, 1500)
        }
    }

    private fun setEnvironment() {
        binding.tvEnvironment.text = getString(R.string.environment)
    }

    private fun setSplashy() {
        Handler(Looper.getMainLooper()).postDelayed({
            splashViewModel.validateRemoteConfigs()
        }, 1500)
        binding.ivLogo.animationXZoom(
            Zoom.ZOOM_IN,
            duration = 1500
        )
    }
}