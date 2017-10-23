package com.example.katrindrozhak.kotlinproject

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnItemClicked {

    override fun onItemClick(book: Book) {
        val intent = Intent(this, ShowBookDetail::class.java)

        intent.putExtra(KEY_BOOK_ID, book.bookId)
        intent.putExtra(KEY_BOOK_NAME, book.name)
        intent.putExtra(KEY_BOOK_PRICE, book.price)
        intent.putExtra(KEY_BOOK_STOCK, book.inStock)

        startActivity(intent)
    }

    private var recyclerView: RecyclerView? = null

    private var books: List<Book> = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewBooks) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        getBooks()

    }

    private fun getBooks() {
        val loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false)

        val service = BookService()

        val call = service.retrofitService()
        call?.getBooks()?.enqueue(object : Callback<List<Book>> {
            override fun onFailure(call: Call<List<Book>>?, t: Throwable?) {
                throw NotImplementedError("An operation is not implemented: ")
            }

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                loading.dismiss()
                response.body()?.let { body ->
                    books = body
                    showList()
                }
            }

        })
    }

    private fun showList() {

        val adapter = BooksAdapter(books as ArrayList<Book>)
        adapter.addData(books as ArrayList<Book>)
        recyclerView!!.adapter = adapter
        adapter.setOnClick(this)
    }

    companion object {
        //Root URL of our web service
        val ROOT_URL = "https://api.myjson.com/"

        //Strings to bind with intent will be used to send data to other activity
        val KEY_BOOK_ID = "key_book_id"
        val KEY_BOOK_NAME = "key_book_name"
        val KEY_BOOK_PRICE = "key_book_price"
        val KEY_BOOK_STOCK = "key_book_stock"
    }
}
