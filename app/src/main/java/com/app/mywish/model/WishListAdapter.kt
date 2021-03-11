package com.app.mywish.model

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mywish.R
import com.app.mywish.WishList.Companion.listOfWish
import com.app.mywish.model.Wish

class WishListAdapter(listOfWish : MutableList<Wish>):
RecyclerView.Adapter<WishListAdapter.WishHolder>(){

    //Método para adicionar wish na listWish
    fun adicionarWish(lista: MutableList<Wish>, wish: Wish) {
        lista.add(wish)
        notifyDataSetChanged()
    }

    //Método para remover wish da listWish
    //fun removeWish(listOfWish: MutableList<Wish>, wish: Wish) {
    //    listOfWish.removeAll()
    //    notifyDataSetChanged()

    //}
    //O que vai ser visualizado e inserido na RecycleView
    class WishHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wishWished: TextView = view.findViewById(R.id.txt_itemWish)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_wish_list, parent, false)
        return WishHolder(view)
    }

    override fun onBindViewHolder(holder: WishHolder, position: Int) {
        holder.wishWished.text = listOfWish[position].wish

        holder.itemView.setOnClickListener{
            val builder = AlertDialog.Builder(it.context)
        builder.setTitle("Wish")
        builder.setMessage("Quer mesmo desfazer esse desejo?")
        builder.setPositiveButton("Sim"){dialog, which ->
            listOfWish.removeAt(position)
            notifyDataSetChanged()
        }
        builder.setNegativeButton("Não"){dialog, which ->}

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int {

        return listOfWish.size
    }}

