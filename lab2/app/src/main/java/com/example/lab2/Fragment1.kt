package com.example.lab2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.fragment_fragment1) {
    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textField = view.findViewById<TextView>(android.R.id.text1)
    }

    internal var activityCallBack: Fragment1Listener? = null
    interface Fragment1Listener {
        fun onButtonClick(position: Int)

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("USR", "onAttach received!!!")
        activityCallBack = context as Fragment1Listener

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_fragment1, container, false)
        // Inflate the layout for this fragment
        val rvitems = inflate.findViewById<RecyclerView>(R.id.idRecycleList);
        rvitems?.layoutManager = LinearLayoutManager(context)
        rvitems?.adapter = object : RecyclerView.Adapter<ItemHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context).inflate(
                        android.R.layout.simple_list_item_1, parent,
                        false
                    )
                )
            }
            override fun getItemCount(): Int {
                return GlobalModel.presidents.size
            }
            override fun onBindViewHolder(holder: ItemHolder, position: Int) {
                holder.textField.text = GlobalModel.presidents[position].name
            }
        }
        return inflate
    }
}
