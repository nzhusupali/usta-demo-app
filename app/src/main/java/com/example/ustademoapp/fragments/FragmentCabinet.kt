package com.example.ustademoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ustademoapp.R
import com.example.ustademoapp.databinding.FragmentCabinetBinding
import com.example.ustademoapp.fragments.adapter.CabinetAdapter
import com.example.ustademoapp.fragments.adapter.NewsParam

class FragmentCabinet : Fragment() {
    private lateinit var arrayList: ArrayList<NewsParam>
    private lateinit var adapter: CabinetAdapter
    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentCabinetBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCabinetBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root
    }

    // recyclerView и запуск остальных функции
    private fun initRecyclerView() {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        arrayList = arrayListOf()

        adapter = CabinetAdapter(arrayList)

        addNews()

        recyclerView.adapter = adapter
        recyclerView.isNestedScrollingEnabled = false

    }

    // Добавление items
    private fun addNews() {
        arrayList.add(
            NewsParam(
                R.drawable.img_1,
                getString(R.string.example_title),
                getString(R.string.example_description),
                246,
                "29.01.2022",
                "02:02"
            )
        )
        arrayList.add(
            NewsParam(
                R.drawable.img_2,
                getString(R.string.example_title),
                getString(R.string.example_description),
                246,
                "29.01.2022",
                "02:02"
            )
        )
        arrayList.add(
            NewsParam(
                R.drawable.img_3,
                getString(R.string.example_title),
                getString(R.string.example_description),
                246,
                "29.01.2022",
                "02:02"
            )
        )
        arrayList.add(
            NewsParam(
                R.drawable.img_4,
                getString(R.string.example_title),
                getString(R.string.example_description),
                246,
                "29.01.2022",
                "02:02"
            )
        )


    }


}