package com.example.ustademoapp.fragments.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ustademoapp.R

class CabinetAdapter(private var newsList: ArrayList<NewsParam>) :
    RecyclerView.Adapter<CabinetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_news, parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val params: NewsParam = newsList[position]

        holder.itemView.setOnClickListener { v ->
            val context = v.context as AppCompatActivity
            Log.d("itemAdapter", "Test")
            val fragment = FragmentOpenItem()

            context.supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment_cabinet, fragment)
                .addToBackStack(null)
                .commit()
        }

        holder.image.setImageResource(params.image)
        holder.title.text = params.title
        holder.descriptions.text = params.description
        holder.view.text = params.view.toString()
        holder.date.text = params.date
        holder.time.text = params.time

    }

    override fun getItemCount(): Int {
        return newsList.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val title: TextView = itemView.findViewById(R.id.item_title)
        val descriptions: TextView = itemView.findViewById(R.id.item_description)
        val view: TextView = itemView.findViewById(R.id.item_view)
        val date: TextView = itemView.findViewById(R.id.item_date)
        val time: TextView = itemView.findViewById(R.id.item_time)

    }

}