package com.example.s205420__lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205420__lykkehjulet.recycle.ItemsViewModel
import com.example.s205420__lykkehjulet.recycle.RecycleAdapter



class BlankFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        for (i in 1..20){
            data.add(ItemsViewModel(R.drawable.player1,"items"+ i))
        }
        val adapter = RecycleAdapter()
        recyclerView.adapter = adapter

    }


}