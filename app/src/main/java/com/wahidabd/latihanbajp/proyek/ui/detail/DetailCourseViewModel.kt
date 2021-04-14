package com.wahidabd.latihanbajp.proyek.ui.detail

import androidx.lifecycle.ViewModel
import com.wahidabd.latihanbajp.proyek.data.CourseEntity
import com.wahidabd.latihanbajp.proyek.data.DataDummy
import com.wahidabd.latihanbajp.proyek.data.ModuleEntity

class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun selectedCourse(courseId: String){
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity
        val courseEntity = DataDummy.generateDummyCourses()
        for (courseEntity in courseEntity){
            if (courseEntity.courseId == courseId){
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}