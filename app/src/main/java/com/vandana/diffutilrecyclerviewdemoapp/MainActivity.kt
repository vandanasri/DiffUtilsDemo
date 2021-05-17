package com.vandana.diffutilrecyclerviewdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val places = listOf(
            "Statue of Liberty",
            "Eiffel Tower",
            "Big Ben",
            "Leaning Tower of Pisa",
            "Colosseum",
            "Empire State Building",
            "Taj Mahal",
            "Golden Gate Bridge",
            "London Eye",
            "Sydney Opera House",
            "Little Mermaid"
    )
    private val sports = listOf(
            "Soccer",
            "Basketball",
            "Tennis",
            "Baseball",
            "Golf",
            "Volleyball",
            "Cricket",
            "Badminton",
            "Table Tennis",
            "Running",
            "Swimming",
            "Surfing"
    )

    private fun show(name: String) {
        Toast.makeText(this, "$name clicked!", Toast.LENGTH_SHORT).show()
    }

    private fun useNotifyDataSet() {
        val adapter = MyNotifyDataSetAdapter(places)
        recyclerView.adapter = adapter
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        adapter.ItemClickListener = { position, name ->
            show(name)
        }
        adapter.updateList(places)

    }

    private fun useDiffUtil() {
        val adapter = MyDiffUtilAdapter(sports)
        recyclerView.adapter = adapter
        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)

        adapter.ItemClickListener = { position, name ->
            show( name)
        }
        adapter.updateList(sports)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        useNotifyDataSet()

        btnOne.setOnClickListener {
            useNotifyDataSet()
            btnOne.setBackgroundColor(resources.getColor(R.color.purple_200))
            btnTwo.setBackgroundColor(resources.getColor(R.color.purple_500))
        }
        btnTwo.setOnClickListener {
            useDiffUtil()
            btnTwo.setBackgroundColor(resources.getColor(R.color.purple_200))
            btnOne.setBackgroundColor(resources.getColor(R.color.purple_500))

        }
    }
}