package com.plcoding.graphqlcountriesapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.plcoding.graphqlcountriesapp.launchAndCollect
import com.plcoding.graphqlprep.R
import com.plcoding.graphqlprep.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply {  }
//        viewLifecycleOwner.launchAndCollect(state){
//
//        }
    }

}