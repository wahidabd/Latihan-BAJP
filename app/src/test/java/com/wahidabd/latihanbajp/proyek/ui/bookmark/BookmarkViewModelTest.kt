package com.wahidabd.latihanbajp.proyek.ui.bookmark

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setup(){
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmark(){
        val courseEntity = viewModel.getBookmarks()
        assertNotNull(courseEntity)
        assertEquals(5, courseEntity.size)
    }
}