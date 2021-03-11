package com.app.mywish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mywish.model.Wish
import com.app.mywish.model.WishListAdapter

class WishList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)

        val wishWished = intent.extras?.get("").toString()
//            textView.text = wishWished

//        var wishedList = mutableListOf<Wish>(
//            Wish(wish = "texto"))

        var rvWished = findViewById<RecyclerView>(R.id.wishList)
//      var addWish = findViewById<Button>(R.id.btnWish)
//      var removeWish = findViewById<Button>(R.id.btnRemove)

        var adapterWish = WishListAdapter(listOfWish)
        rvWished.adapter = adapterWish
        adapterWish.adicionarWish(listOfWish, Wish(wishWished))

        rvWished.layoutManager = LinearLayoutManager(this)
    }

    companion object{
        val listOfWish: MutableList<Wish> = mutableListOf(

        )
    }
}

//            addWish.setOnClickListener{
//                adapterWish.adicionarWish(
//                    Wish(wish = "")
//                )
//            }
//        removeWish.setOnClickListener{
//            adapterWish.removeWish()
//                if (it.isClickable){
//
//                    removeWish.getHint()
//                    Wish(wish = "")
//                }
//}
