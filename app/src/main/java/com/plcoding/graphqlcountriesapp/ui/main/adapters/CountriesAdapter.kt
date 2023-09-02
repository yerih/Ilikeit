package com.plcoding.graphqlcountriesapp.ui.main.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.plcoding.graphqlcountriesapp.basicDiffUtil
import com.plcoding.graphqlcountriesapp.domain.Country
import com.plcoding.graphqlcountriesapp.inflate
import com.plcoding.graphqlprep.R
import com.plcoding.graphqlprep.databinding.ItemListCountryBinding

class CountriesAdapter(

): ListAdapter<Country, CountriesAdapter.ViewHolder>(
    basicDiffUtil { old, new -> old.name == new.name }) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemListCountryBinding.bind(view)
        fun bind(country: Country){ binding.country = country }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent.inflate(R.layout.item_list_country, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val country = getItem(position)
        holder.apply {
            bind(country);
            itemView.setOnClickListener {  }
        }
    }
}



