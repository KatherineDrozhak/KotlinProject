package com.example.katrindrozhak.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

/**
 * Created by katrindrozhak on 08.09.17.
 */
class ShowBookDetail : AppCompatActivity() {

    private var textViewBookName: TextView? = null
    private var textViewBookPrice: TextView? = null
    private var textViewBookInStock: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_book_details)

        textViewBookName = findViewById(R.id.textViewBookName) as TextView
        textViewBookPrice = findViewById(R.id.textViewBookPrice) as TextView
        textViewBookInStock = findViewById(R.id.textViewBookInStock) as TextView

        val intent = intent

        textViewBookName!!.text = "Title: " + intent.getStringExtra(MainActivity.KEY_BOOK_NAME)
        textViewBookPrice!!.text = "Price: " + intent.getStringExtra(MainActivity.KEY_BOOK_PRICE)
        textViewBookInStock!!.text = "InStock: " + intent.getIntExtra(MainActivity.KEY_BOOK_STOCK, 0).toString()

    }
}