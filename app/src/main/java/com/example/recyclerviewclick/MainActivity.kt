package com.example.recyclerviewclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewclick.adapter.*
import com.example.recyclerviewclick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CarClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var carList: ArrayList<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val car1 = Car("Bmw", 2022, true)
        val car2 = Car("Audi", 2021, false)
        val car3 = Car("Porsche", 2020, false)
        val car4 = Car("Ferrari", 2019, true)


        carList = ArrayList()
        carList.add(car1)
        carList.add(car2)
        carList.add(car3)
        carList.add(car4)

        binding.rvOption1.adapter = CarAdapterFirst(carList)

        binding.rvOption2.adapter = CarAdapterSecond(carList) { carItem: Car ->
            Log.d("Car Second: ", carItem.brand)
        }

        binding.rvOption3.adapter = ItemAdapterThird(carList, this)


        binding.rvOption4.adapter = CarAdapterSecondExtended(carList, object : RowClickListener<Car> {
            override fun onRowClick(pos: Int, item: Car) {
                Log.d("Car SecondExtended: ", item.brand)
            }

        })
    }

    override fun itemClicked(position: Int, car: Car) {
        Log.d("Car Third: ", car.brand)
    }
}