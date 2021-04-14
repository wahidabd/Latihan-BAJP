package com.wahidabd.latihanbajp.proyek.ui.academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.wahidabd.latihanbajp.databinding.FragmentAcademyBinding
import com.wahidabd.latihanbajp.proyek.data.DataDummy


class AcademyFragment : Fragment() {

    private lateinit var _binding: FragmentAcademyBinding
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAcademyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AcademyViewModel::class.java]
            val course = viewModel.getCourse()

            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourse(course)

            with(binding.rvAcademy){
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }
}