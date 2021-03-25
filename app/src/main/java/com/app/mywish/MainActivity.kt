package com.app.mywish


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.text.isDigitsOnly
import com.app.mywish.model.Wish
import kotlinx.android.synthetic.main.activity_wish_list.*
import kotlinx.android.synthetic.main.activity_wish_list.view.*


class MainActivity : AppCompatActivity() {

    lateinit var botaoInsert: Button
    lateinit var wish: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        botaoInsert = findViewById(R.id.btnWish)
        wish = findViewById(R.id.txt_writeWish)


            botaoInsert.setOnClickListener {
                //    Handler(Looper.getMainLooper()).postDelayed({
                val telaList = Intent(this, WishList::class.java)
                telaList.putExtra("wish", wish.text)
                if(wish.text.isNotEmpty() == true){
                    wish.setText("")
                    wish.requestFocus()
                    startActivity(telaList)
                }else{
                    Toast.makeText(applicationContext, "Você deve fazer um pedido", LENGTH_SHORT).show()
                }


            }
        }
    }
//    check(wish.text.isNotEmpty())
//    if (wish.text.isNotEmpty()) {
//        Toast.makeText(applicationContext, "Você deve fazer um pedido", LENGTH_SHORT)
//    } else {


