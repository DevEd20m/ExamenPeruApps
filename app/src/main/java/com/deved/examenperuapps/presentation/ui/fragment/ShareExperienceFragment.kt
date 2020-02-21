package com.deved.examenperuapps.presentation.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.deved.examenperuapps.R
import com.deved.examenperuapps.presentation.interfaces.BottomNavigation

/**
 * A simple [Fragment] subclass.
 */
class ShareExperienceFragment : Fragment(),BottomNavigation {
    override fun newInstance(): Fragment {
        return ShareExperienceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share_experience, container, false)
    }


}
