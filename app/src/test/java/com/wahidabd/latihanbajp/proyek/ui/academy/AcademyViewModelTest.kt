package com.wahidabd.latihanbajp.proyek.ui.academy

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class AcademyViewModelTest{
    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setup(){
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntity =  viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(5, courseEntity.size)
    }


}