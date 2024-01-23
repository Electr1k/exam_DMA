package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.RV)

        val booksList = listOf(
            Book("Книга1", "Марк Твен", 1),
            Book("Книга2", "Стивен Хоккинг", 1),
            Book("Книга3", "Марк Твен", 1),
            Book("Книга4", "Марк Твен", 1),
            Book("Книга5", "Марк Твен", 1),
            Book("Книга6", "Марк Твен", 1),
            Book("Книга7", "Марк Твен", 1),
            )

        val adapter = BooksListAdapter(booksList, this, {})
        rv.adapter = adapter
        rv.layoutManager =
            GridLayoutManager(this, 1)
    }
}