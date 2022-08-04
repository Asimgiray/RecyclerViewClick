package com.example.recyclerviewclick

interface RowClickListener<T> {
    fun onRowClick(pos: Int, item: T)
}