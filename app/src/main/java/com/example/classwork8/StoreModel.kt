package com.example.classwork8

data class StoreModel(
    val itemList: List<Item>
){
    data class Item(
        val title: String?,
        val cover: String?,
        val price: String?,
        val liked: Boolean? = false
    )
}