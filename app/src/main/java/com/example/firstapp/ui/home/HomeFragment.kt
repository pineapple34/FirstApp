package com.example.firstapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentHomeBinding
import com.example.firstapp.db.*
import com.example.firstapp.recadapters.FeelRecycler
import com.example.firstapp.recadapters.Feel
import com.example.firstapp.recadapters.State
import com.example.firstapp.recadapters.StateRecycler
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val feel_recycler: RecyclerView = root.findViewById(R.id.feel_rec)
        val feels = MyRetrofit().getRetrofit()
        val api_ret = feels.create(Api::class.java)
        val feels_call: Call<Feelings> = api_ret.getFeel()
        feels_call.enqueue(object : retrofit2.Callback<Feelings>{
            override fun onResponse(call: Call<Feelings>, response: Response<Feelings>) {
                if (response.isSuccessful){
                    feel_recycler.adapter = response.body()?.let { FeelRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<Feelings>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        //feel_recycler.adapter = FeelRecycler(requireContext(), Feel.MyFeel().list)

        val state_recycler: RecyclerView = root.findViewById(R.id.state_rec)
        val quotes = MyRetrofit().getRetrofit()
        val api_ret2 = quotes.create(Api::class.java)
        val quotes_call: Call<Quotes> = api_ret2.getQuotes()
        quotes_call.enqueue(object : retrofit2.Callback<Quotes>{
            override fun onResponse(call: Call<Quotes>, response: Response<Quotes>) {
                if (response.isSuccessful){
                    state_recycler.adapter = response.body()?.let { StateRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<Quotes>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}