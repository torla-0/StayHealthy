package com.example.stayhealthy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stayhealthy.adapter.GymAdapter
import com.example.stayhealthy.model.Gym


class SpasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gymAdapter: GymAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data
        val gyms = listOf(
            Gym(R.drawable.spa1_herbalspa, "Herbal Spa", 43.85296567478428, 18.389752326946738),
            Gym(R.drawable.spa2_ah, "Amman & Hammam Spa", 43.85879495931077, 18.43233508595681),
            Gym(R.drawable.spa3_goodlife, "Goodlife Spa", 43.86005667322145, 18.420456614792833),
            Gym(R.drawable.spa4_amari, "Amari Spa", 43.858517884239475, 18.42312287061275),
            Gym(R.drawable.spa5_maab, "Ma`ab Spa", 43.848074995316715, 18.399355271125405),
            Gym(R.drawable.h1_hl, "HL Hijama Center", 43.86051488728895, 18.43229298410479),
            Gym(R.drawable.h2_am, "A&M Hijama Center", 43.886651749165814, 18.412122324581784),
            Gym(R.drawable.h3_redmoon, "Red Moon Hijama Center",43.859185458776516, 18.354144566895634),
        )

        recyclerView = view.findViewById(R.id.recyclerViewSpas)
        recyclerView.layoutManager = LinearLayoutManager(context)
        gymAdapter = GymAdapter(gyms)
        recyclerView.adapter = gymAdapter
    }
}