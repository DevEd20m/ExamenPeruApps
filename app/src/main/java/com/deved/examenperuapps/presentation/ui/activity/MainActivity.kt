package com.deved.examenperuapps.presentation.ui.activity


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.deved.examenperuapps.R
import com.deved.examenperuapps.presentation.interfaces.BottomNavigation
import com.deved.examenperuapps.presentation.ui.BaseActivity
import com.deved.examenperuapps.presentation.ui.fragment.PerfilFragment
import com.deved.examenperuapps.presentation.ui.fragment.PlacesFragment
import com.deved.examenperuapps.presentation.ui.fragment.ShareExperienceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    lateinit var fragment: Fragment

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomNavigationView.setOnNavigationItemSelectedListener {

            var fragment: Fragment? = null
            when (it.itemId) {
                R.id.action_places -> {
                    fragment = PlacesFragment().newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_experiences -> {
                    fragment = ShareExperienceFragment().newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_perfil -> {
                    fragment = PerfilFragment().newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.action_places
    }

    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            addToBackStack(null)
            commit()
        }
    }



}