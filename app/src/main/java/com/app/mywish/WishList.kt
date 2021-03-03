package com.app.mywish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mywish.model.Wish
import com.app.mywish.model.WishListAdapter
import kotlinx.android.synthetic.main.activity_wish_list.*

class WishList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)

        var wishedList = mutableListOf<Wish>(
            Wish(wish = " ")
        )

        var rvWished = findViewById<RecyclerView>(R.id.wishList)
        var addWish = findViewById<Button>(R.id.btnWish)

        var adapterWish = WishListAdapter(wishedList)
            rvWished.adapter = adapterWish

            addWish.setOnClickListener{
                adapterWish.adicionarWish(
                    Wish(wish = "teste")
                )
            }


        rvWished.layoutManager = LinearLayoutManager(this)


           // fazerPedido.adapter.notifyDataSetChanged()

        }
    }
