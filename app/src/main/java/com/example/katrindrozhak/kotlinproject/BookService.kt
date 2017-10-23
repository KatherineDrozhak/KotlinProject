package com.example.katrindrozhak.kotlinproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by katrindrozhak on 13.09.17.
 */
open class BookService {

     open fun retrofitService(): BooksAPI? {

        val retrofit = Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(BooksAPI::class.java)

    }
}