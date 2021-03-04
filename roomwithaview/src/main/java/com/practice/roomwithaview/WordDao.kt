package com.practice.roomwithaview

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Implement the DAO
 * WordDao is an interface; DAOs must either be interfaces or abstract classes.
 * @Dao : identifies it as a DAO class for Room.
 * OnConflictStrategy.IGNORE: The selected onConflict strategy ignores a new word if it's exactly the same as one already in the list.
 * suspend fun : Declares a suspend function.
 * @Query : requires that you provide a SQL query as a string parameter to the annotation, allowing for complex read queries and other operations.
 */
@Dao
interface WordDao {

//    @Query("SELECT * FROM word_table ORDER BY word ASC")
//    fun getAlphabetizedWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    /**
     * To observe data changes we will use "Flow" from kotlinx-coroutines.
     * Use a return value of type Flow in your method description, and Room generates all necessary code to update the Flow when the database is updated.
     * <br>
     * <b>A Flow is an async sequence of values</b>
     * Flow produces values one at a time (instead of all at once) that can generate values from async operations like network requests, database calls, or other async code.
     * It supports coroutines throughout its API, so you can transform a flow using coroutines as well!
     */
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>
}