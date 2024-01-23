package com.example.exam

import androidx.recyclerview.widget.RecyclerView
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BooksListAdapter (
    private val booksList: List<Book>,
    private val activity: Activity,
    private val update: () -> Unit
): RecyclerView.Adapter<BooksListAdapter.BookHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return  BookHolder(view)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.book_name.text = booksList[position].name
        holder.book_author.text = booksList[position].author
        holder.shelf.text = booksList[position].shelf.toString()

//        holder.itemView.setOnLongClickListener {
//            onLongClick(recipeList[position], activity = activity)
//            update()
//            true
//        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var book_name: TextView
        var book_author: TextView
        var shelf: TextView

        init {
            book_name = itemView.findViewById(R.id.name)
            book_author = itemView.findViewById(R.id.author)
            shelf = itemView.findViewById(R.id.number)
        }
    }
}