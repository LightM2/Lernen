package com.example.lernen.room

interface Word {
    fun getItemType(): Int
}

data class Lesson(
        var lesson: String
): Word {
    override fun getItemType(): Int = 1
}