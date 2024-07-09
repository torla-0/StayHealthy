package com.example.stayhealthy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stayhealthy.adapter.GymAdapter
import com.example.stayhealthy.model.Gym

class GymsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gymAdapter: GymAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gyms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data
        val gyms = listOf(
            Gym(R.drawable.gym1_all4sport, "ALL4SPORT Fitness", 43.85140754532377, 18.373991577163967),
            Gym(R.drawable.gym2_xxl, "XXL Sport center",43.84907249497285, 18.350917866751796),
            Gym(R.drawable.gym3_diskogym, "Disko Gym", 43.85087670370083, 18.36292119123788),
            Gym(R.drawable.gym4_hlgym, "HL Gym", 43.84998101180431, 18.355982882866773),
            Gym(R.drawable.gym5_womansgym, "Women's Gym", 43.853641768474446, 18.375441228406682),
            Gym(R.drawable.gym5_allinfitnessmalta, "ALL IN Fitness Malta", 43.85402038753696, 18.381977496666913),
            Gym(R.drawable.gym6_brickfit, "Brick Fit Club", 43.86598719649012, 18.409230928517143),
            Gym(R.drawable.gym7_allinfitnessbingo, "ALL IN Fitness Bingo", 43.850455094412105, 18.35457733525132),
            Gym(R.drawable.gym8_oxidegym, "Oxide Gym", 43.842193259453765, 18.32584889655888),
            Gym(R.drawable.gym9_universum, "Universum Fitness", 43.855733827809985, 18.382359751179525),
            Gym(R.drawable.gym10_progym, "Pro Gym", 43.87343776363517, 18.4097135285816),
            Gym(R.drawable.gym11_extreme, "Extreme Sport", 43.84019770071404, 18.329484805528953),
        )

        recyclerView = view.findViewById(R.id.recyclerViewGyms)
        recyclerView.layoutManager = LinearLayoutManager(context)
        gymAdapter = GymAdapter(gyms)
        recyclerView.adapter = gymAdapter
    }
}