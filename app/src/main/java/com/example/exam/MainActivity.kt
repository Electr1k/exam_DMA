package com.example.exam

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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
        val db = DataBase.getDatabase(this)

        up_btn.setOnClickListener{
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        rv.layoutManager =
            GridLayoutManager(this, 1)
        findViewById<Button>(R.id.addBook).setOnClickListener {
            try {
                val author = findViewById<TextView>(R.id.author_ET).text.toString()
                val name = findViewById<TextView>(R.id.name_ET).text.toString()
                val count = findViewById<TextView>(R.id.count_list_ET).text.toString().toInt()
                Thread {
                    db.getDao().insertBook(Book(null, name, author, count))
                    val booksList = db.getDao().getAllBook()
                    val adapter = BooksListAdapter(booksList, this, {})
                    runOnUiThread {
                        rv.adapter = adapter
                    }
                }.start()
            }
            catch (e: Exception){
                Toast.makeText(this, "Ooops...", Toast.LENGTH_SHORT).show()
            }
        }
        Thread{
            val booksList = db.getDao().getAllBook()
            val adapter = BooksListAdapter(booksList, this, {})
            runOnUiThread{
                rv.adapter = adapter
            }
        }.start()

    }
}