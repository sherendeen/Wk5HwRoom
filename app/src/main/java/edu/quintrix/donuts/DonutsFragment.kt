package edu.quintrix.donuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.quintrix.donuts.databinding.FragmentDonutsBinding

//import com.example.viewmodelexample.BR.myViewModel //BR = binding root


/**
 * A simple [Fragment] subclass.
 * Use the [DonutsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DonutsFragment : Fragment() {
    private var _binding : FragmentDonutsBinding? = null
    private val binding get() = _binding
    //lateinit var binding: FragmentTasksBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDonutsBinding.inflate(inflater,container,false)
        val view = binding!!.root


        //     _binding = LayoutInflater.container: ViewGroup? .inflate(inflater, R.layout.fragment_tasks, container, false)
        //binding.setLifecycleOwner(this)


        val application= requireNotNull(this.activity).application
        val dao = DonutDatabase.getInstance(application).donutDao
        val viewModelFactory = DonutsViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(DonutsViewModel::class.java)

        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner=viewLifecycleOwner//set layout's lifecycleOwner so that it can respond to data updates
        val adapter = DonutItemAdapter()
        binding!!.tasksList.adapter=adapter

        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            if (it != null) it.let {
                adapter.data = it
            }
        })

        return view
    }

}