package com.github.novotnyr.drliko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private val cityViewModel: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isSmallDevice()) {
            supportFragmentManager.commit {
                replace(R.id.dynamicFragmentMainActivity, MasterFragment())
            }

            cityViewModel.selectedCity.observe(this) {
                supportFragmentManager.commit {
                    replace(R.id.dynamicFragmentMainActivity, FragmentDetail())
                    addToBackStack(null)
                }
            }
        }
    }

    private fun isSmallDevice(): Boolean {
        return findViewById<View>(R.id.dynamicFragmentMainActivity) != null
    }
}