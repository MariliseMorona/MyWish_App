package com.app.mywish.model

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog.show
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.app.mywish.R
import com.app.mywish.WishList
import com.app.mywish.WishList.Companion.listOfWish



class WishListAdapter(listOfWish: MutableList<Wish>) :
    RecyclerView.Adapter<WishListAdapter.WishHolder>() {



    //Método para adicionar wish na listWish e limitar ela a 3 wishes
    fun adicionarWish(lista: MutableList<Wish>, wish: Wish) {
        if(lista.size <= 2) {
            lista.add(wish)
            notifyDataSetChanged()


        }
    }

    private fun <Wish> MutableList<Wish>.removeAt() {
        listOfWish.remove(this)
        notifyDataSetChanged()
    }


    //Método paa remover pedidos duplicados
//    fun <Wish> MutableList<WishList>.removeDuplicates(): Boolean {
//        val set = mutableSetOf<Wish>()
//        return retainAll { set.add(it) }

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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wish, parent, false)
        return WishHolder(view)
    }

    override fun onBindViewHolder(holder: WishHolder, position: Int) {
        holder.wishWished.text = listOfWish[position].wish

        holder.itemView.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Ok, mas ..")
            builder.setMessage("Tem certeza que quer desfazer esse desejo?")
            builder.setPositiveButton("Sim") { dialog, which ->
                listOfWish.removeAt(position)
                this.notifyDataSetChanged()
            }
            builder.setNegativeButton("Não") { dialog, which -> }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int {

        return listOfWish.size
    }

}









