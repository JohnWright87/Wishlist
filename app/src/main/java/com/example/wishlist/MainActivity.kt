package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var wishesItems: List<ItemList>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submitButton = findViewById<Button>(R.id.button)
        val itemsAdded : MutableList<ItemList> = ArrayList()
        val wishlstRV = findViewById<RecyclerView>(R.id.itemRecycle)

        fun setItem(): MutableList<ItemList>
        {
            val itemName = findViewById<EditText>(R.id.input_name).text.toString()
            val itemPrice = findViewById<EditText>(R.id.input_price).text.toString()
            val itemUrl = findViewById<EditText>(R.id.input_url).text.toString()
            val item2Add = ItemList(itemName,itemPrice,itemUrl)
            itemsAdded.add(item2Add)
            return itemsAdded
        }


        submitButton.setOnClickListener{
            wishesItems = setItem()
            val item = WishlistAdapter(wishesItems)
            wishlstRV.adapter = item
            wishlstRV.layoutManager = LinearLayoutManager(this)
            item.notifyDataSetChanged()
            wishlstRV.invalidate()
            item.notifyItemInserted(item.itemCount)
        }



    }
}