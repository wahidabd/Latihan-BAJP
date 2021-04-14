package com.wahidabd.latihanbajp.proyek.ui.bookmark

import com.wahidabd.latihanbajp.proyek.data.CourseEntity

interface BookmarkCallback {
    fun onShareClick(data: CourseEntity)
}