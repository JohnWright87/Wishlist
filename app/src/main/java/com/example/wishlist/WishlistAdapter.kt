package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishItem: List<ItemList>) : RecyclerView.Adapter<WishlistAdapter.ItemViewHolder>()
{
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val itemNameView: TextView
        val price: TextView
        val itemLocation: TextView

        init
        {
            itemNameView = itemView.findViewById(R.id.itemName)
            price = itemView.findViewById(R.id.priceText)
            itemLocation = itemView.findViewById(R.id.locationText)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishlistView = inflater.inflate(R.layout.wishlist_item_activity_main,parent,false)
        return ItemViewHolder(wishlistView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val wishitems = wishItem[position]
        holder.itemNameView.text = wishitems.itemName
        holder.price.text = wishitems.itemPrice
        holder.itemLocation.text = wishitems.urlWebsite

    }

    override fun getItemCount(): Int {
        return wishItem.count()
    }
}