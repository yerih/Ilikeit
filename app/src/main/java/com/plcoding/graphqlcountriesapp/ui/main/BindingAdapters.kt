package com.plcoding.graphqlcountriesapp.ui.main

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.ui.main.adapters.CountriesAdapter


@BindingAdapter("items")
fun RecyclerView.setItems(artists: List<Country>?){
    artists?.let { (adapter as? CountriesAdapter)?.submitList(it) }
}


@BindingAdapter("visible")
fun View.setVisible(visible: Boolean) = if(visible) visibility = View.VISIBLE
else visibility = View.GONE

