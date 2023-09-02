package com.plcoding.graphqlcountriesapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.plcoding.graphqlcountriesapp.launchAndCollect
import com.plcoding.graphqlcountriesapp.log
import com.plcoding.graphqlcountriesapp.toast
import com.plcoding.graphqlcountriesapp.ui.main.MainViewModel.UiEvent.*
import com.plcoding.graphqlcountriesapp.ui.main.adapters.CountriesAdapter
import com.plcoding.graphqlprep.R
import com.plcoding.graphqlprep.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val adapter = CountriesAdapter{ country -> log("$country")}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply { recycler.adapter = adapter }
        launchAndCollect(viewModel.state){
            binding.countries = it.list
        }
        launchAndCollect(viewModel.events){ event ->
            when(event){
                is ToastEvent -> toast("error: ${event.msg}")
            }
        }
    }

}