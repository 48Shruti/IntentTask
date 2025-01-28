package com.shruti.intenttask

import android.icu.text.Transliterator.Position

interface StudentInterface {
    fun update(student: Student, position: Int)
    fun delete(student: Student, position: Int)
}