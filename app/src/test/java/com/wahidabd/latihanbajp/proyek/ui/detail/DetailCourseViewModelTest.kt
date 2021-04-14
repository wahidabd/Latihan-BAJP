package com.wahidabd.latihanbajp.proyek.ui.detail

import com.wahidabd.latihanbajp.proyek.data.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailCourseViewModelTest {
    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setup(){
        viewModel = DetailCourseViewModel()
        viewModel.selectedCourse(courseId)
    }

    @Test
    fun getCourse(){
        viewModel.selectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    @Test
    fun getModules(){
        val moduleEntity = viewModel.getModules()
        assertNotNull(moduleEntity)
        assertEquals(7, moduleEntity.size.toLong())
    }
}