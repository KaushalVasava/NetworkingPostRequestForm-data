package com.lahsuak.apps.task1.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.lahsuak.apps.task1.ui.repo.DataRepository
import com.lahsuak.apps.task1.R
import com.lahsuak.apps.task1.model.Details
import com.lahsuak.apps.task1.ui.adapter.DataAdapter
import com.lahsuak.apps.task1.ui.repo.ViewModelFactory
import com.lahsuak.apps.task1.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: DataAdapter
    private var dataList = mutableListOf<Details>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val repository = DataRepository()
//        val viewModelFactory = ViewModelFactory(repository)

//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        adapter = DataAdapter(this, dataList)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter

        viewModel.pushResults("listing", "1")
        viewModel.myResponse.observe(this, { response ->
            if (response.isSuccessful) {
                val list: List<Details> = response.body()?.results!!.details
                dataList.clear()
                dataList.addAll(list)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}