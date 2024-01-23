package com.example.exam

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var up_btn: ImageView
    private lateinit var bottomSheet: LinearLayout
    private lateinit var behavior: BottomSheetBehavior<LinearLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.RV)
        up_btn = findViewById(R.id.up_menu)
        bottomSheet = findViewById(R.id.bottom_sheet)
        behavior = BottomSheetBehavior.from(bottomSheet)

        up_btn.setOnClickListener{
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
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