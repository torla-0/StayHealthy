package com.example.stayhealthy.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.stayhealthy.R
import com.example.stayhealthy.model.Gym

class GymAdapter(private val gyms: List<Gym>) : RecyclerView.Adapter<GymAdapter.GymViewHolder>() {

    class GymViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.idCardImage1)
        val textView: TextView = itemView.findViewById(R.id.idCardText1)
        val button: Button = itemView.findViewById(R.id.idCardButton1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gym, parent, false)
        return GymViewHolder(view)
    }

    override fun onBindViewHolder(holder: GymViewHolder, position: Int) {
        val gym = gyms[position]
        holder.imageView.setImageResource(gym.imageResId)
        holder.textView.text = gym.name
        holder.button.setOnClickListener {
            val context = holder.itemView.context
            val gmmIntentUri =
                Uri.parse("geo:${gym.latitude},${gym.longitude}?q=${Uri.encode(gym.name)}, Sarajevo")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }
    }

    override fun getItemCount() = gyms.size
}
