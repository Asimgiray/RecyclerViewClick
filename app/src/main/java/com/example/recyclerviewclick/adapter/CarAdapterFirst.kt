package com.example.recyclerviewclick.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewclick.R
import com.example.recyclerviewclick.Car
import com.example.recyclerviewclick.databinding.RowItemBinding

class CarAdapterFirst (private val carList: ArrayList<Car>) : RecyclerView.Adapter<CarAdapterFirst.ViewHolder>() {


    class ViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carList[position]
        holder.binding.txtName.text = car.brand
        holder.binding.txtAge.text = car.model.toString()
        holder.binding.txtSwim.text = car.isDiesel.toString()

        holder.binding.root.setOnClickListener {
            Log.d("Car First: ", car.brand)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : RowItemBinding = DataBindingUtil.inflate(inflater, R.layout.row_item, parent, false)
        return ViewHolder(binding)
    }


}