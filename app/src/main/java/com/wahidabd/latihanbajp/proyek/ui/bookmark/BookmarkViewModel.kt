package com.wahidabd.latihanbajp.proyek.ui.bookmark

import androidx.lifecycle.ViewModel
import com.wahidabd.latihanbajp.proyek.data.CourseEntity
import com.wahidabd.latihanbajp.proyek.data.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}