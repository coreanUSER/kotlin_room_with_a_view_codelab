package com.practice.roomwithaview

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//data class Word(val word: String)

/**
 * Using Kotlin Annotation
 * @Entity(tableName = "" ) : You can specify the name of the table if you want it to be different from the name of the class.
 * @PrimaryKey : Every entity needs a primary key.
 * @ColumnInfo(name = "") : Specifies the name of the column in the table if you wnat it to be different from the name of the member variable.
 * Every property that's stored in the database needs to habe public visibility, which is the Kotlin default
 *
 * You can autogenerate unique keys by annotating the primary key
 * @PrimaryKey(autoGenerate = true) val id: Int
 */
@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)