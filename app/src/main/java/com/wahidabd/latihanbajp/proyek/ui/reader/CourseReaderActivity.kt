package com.wahidabd.latihanbajp.proyek.ui.reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.wahidabd.latihanbajp.R
import com.wahidabd.latihanbajp.databinding.ActivityCourseReaderBinding
import com.wahidabd.latihanbajp.proyek.ui.reader.content.ModuleContentFragment
import com.wahidabd.latihanbajp.proyek.ui.reader.list.ModuleListFragment

class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {

    companion object{

        const val EXTRA_COURSE_ID = "extra_course_id"
    }

    private lateinit var binding: ActivityCourseReaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseReaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]

        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null){
                viewModel.selectedCourse(courseId)
                populateFragment()
            }
        }
    }

    private fun populateFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)
        if (fragment != null) {
            fragment = ModuleListFragment.newInstance()
            transaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    override fun moveTo(position: Int, moduleId: String) {
        val fragment = ModuleContentFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
                .addToBackStack(null)
                .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1){
            finish()
        }else{
            super.onBackPressed()
        }
    }
}