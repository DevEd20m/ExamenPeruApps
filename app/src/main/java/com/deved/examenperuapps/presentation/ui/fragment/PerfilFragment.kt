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
class PerfilFragment : Fragment(),BottomNavigation {
    override fun setUpUi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun newInstance(): Fragment {
        return PerfilFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)


        return view
    }


}
