package com.app.mywish.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mywish.R

class WishListAdapter(private val listOfWish : MutableList<Wish>):
RecyclerView.Adapter<WishListAdapter.WishHolder>(){

    private var listWishRemove = mutableListOf<Wish>()


        //O que vai ser visualizado e inserido na RecycleView
        class WishHolder(view: View) : RecyclerView.ViewHolder(view) {
            val wishWished: TextView = view.findViewById(R.id.txt_wish)

        }

        //Método para adicionar wish na listWish
        fun adicionarWish(newWish: Wish) {
            listOfWish.add(newWish)
            notifyDataSetChanged()
        }

        //Método para remover wish da listWish
        fun removeWish() {
            listOfWish.removeAll(listWishRemove)
            notifyDataSetChanged()
            listWishRemove
        }


        override fun onBindViewHolder(holder: WishHolder, position: Int) {
        holder.wishWished.text = listOfWish[position].wish
    }



    override fun getItemCount(): Int {
        return listOfWish.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return WishHolder(view)
    }


}


