package com.example.katrindrozhak.kotlinproject

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by katrindrozhak on 08.09.17.
 */
interface BooksAPI {

    /*Retrofit get annotation with our URL
      And our method that will return us the list ob Book
   */
    @GET("/bins/jul6f")
    fun getBooks() : Call<List<Book>>
}