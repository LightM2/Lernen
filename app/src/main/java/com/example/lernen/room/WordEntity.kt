package com.example.lernen.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "lesson")
    var lesson: String,

    @ColumnInfo(name = "word")
    var word: String,

    @ColumnInfo(name = "translation")
    var translation: String
):Word {
    override fun getItemType(): Int = 0
}