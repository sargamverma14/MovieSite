package com.example.api.fragments

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.adaptorviewpager.rvAdaptor
import com.example.movieapi.R
import com.example.movieapi.databinding.FragmentFragment1Binding
import com.example.movieapi.viewmodel.MovieViewModel

class fragment1(val fragmentcontext: Context) : Fragment() {

lateinit var myviewmodel:MovieViewModel
lateinit var recyclerview :RecyclerView
//lateinit var binding : FragmentFragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myviewmodel = ViewModelProvider(this)[MovieViewModel::class.java]
    recyclerview.layoutManager = LinearLayoutManager(fragmentcontext)


        var progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Please wait...")
        progressDialog.setCancelable(false)
        progressDialog.create()


        return inflater.inflate(R.layout.fragment_fragment1, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the RecyclerView by its id
        recyclerview = view.findViewById(R.id.rvf1)

        // Now you can set up your RecyclerView, for example, by setting a layout manager and an adapter
        recyclerview?.layoutManager = LinearLayoutManager(context)

        myviewmodel.getMovie().observe(viewLifecycleOwner, Observer {
            recyclerview.adapter = rvAdaptor(fragmentcontext, it)

        })
    }

}