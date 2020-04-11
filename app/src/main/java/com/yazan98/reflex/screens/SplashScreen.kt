package com.yazan98.reflex.screens

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.yazan98.reflex.R
import io.vortex.android.prefs.VortexPrefs
import io.vortex.android.ui.activity.VortexDirectScreen
import kotlinx.coroutines.launch

class SplashScreen : VortexDirectScreen(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            when (VortexPrefs.getUserStatus()) {
                true -> startScreen<MainScreen>(true)
                false -> startScreen<RegisterScreen>(true)
            }
        }
    }

}
