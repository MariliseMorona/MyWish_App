package com.app.mywish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mywish.model.Wish
import com.app.mywish.model.WishListAdapter

class WishList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)

        var wishedList = mutableListOf<Wish>(
            Wish(wish = " ")
        )

        var rvWished = findViewById<RecyclerView>(R.id.wishList)
        var addWish = findViewById<Button>(R.id.btnWish)
        var removeWish = findViewById<Button>(R.id.btnRemove)

        var adapterWish = WishListAdapter(wishedList)
            rvWished.adapter = adapterWish

            addWish.setOnClickListener{
                adapterWish.adicionarWish(
                    Wish(wish = "teste")
                )
            }
        removeWish.setOnClickListener{
            adapterWish.removeWish()
                if (it.isClickable){

                    removeWish.getHint()
                    Wish(wish = "" )
                }
}
        rvWished.layoutManager = LinearLayoutManager(this)


           // fazerPedido.adapter.notifyDataSetChanged()

        }
    }