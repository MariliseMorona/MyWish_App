package com.app.mywish

import android.accounts.AccountManager.get
import android.content.Intent
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getText
import android.os.Bundle as AndroidOsBundle

class MainActivity : AppCompatActivity() {

     lateinit var editWish: EditText


    override fun onCreate(savedInstanceState: AndroidOsBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editWish = findViewById(R.id.edtWish)



    }
        fun onClickBtnEnviar(){
        var wish = editWish.getText().toString()

        var destinadoraActivity = Intent(this, WishList::class.java)

       lateinit var wishMake: AndroidOsBundle

        wishMake.putExtra(wish)

        destinadoraActivity.putExtras(wishMake)

        startActivity(destinadoraActivity)
        }

}

private fun Parcelable.putExtra(wish: String) {

}

