package com.wahidabd.latihanbajp.proyek.ui.academy

import androidx.lifecycle.ViewModel
import com.wahidabd.latihanbajp.proyek.data.CourseEntity
import com.wahidabd.latihanbajp.proyek.data.DataDummy

class AcademyViewModel : ViewModel() {
    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourses()
}