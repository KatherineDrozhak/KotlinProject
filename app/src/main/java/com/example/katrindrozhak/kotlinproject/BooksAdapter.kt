package com.example.katrindrozhak.kotlinproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by katrindrozhak on 13.09.17.
 */
class BooksAdapter(var userList: List<Book>) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

   private lateinit var onClick: OnItemClicked

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: BooksAdapter.ViewHolder, position: Int) {
        val item = userList[position]
        holder.bindItems(item, this.onClick)
    }

    fun addData(books: List<Book>) {
        userList = books
    }

    fun setOnClick(onClick: OnItemClicked) {
        this.onClick = onClick
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var itemTV: TextView? = null

        fun bindItems(book: Book, listener: OnItemClicked?) = with(itemView) {
            itemTV = itemView.findViewById(R.id.item) as TextView
            itemTV!!.text = book.name
            setOnClickListener { listener!!.onItemClick(book) }
        }
    }

}