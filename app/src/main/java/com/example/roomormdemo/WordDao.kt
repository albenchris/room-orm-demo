package com.example.roomormdemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * importing this Flow will cause error
 * import java.util.concurrent.Flow
 */

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    // removed suspend due to errors
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: Word)

    // removed suspend due to errors
    @Query("DELETE FROM word_table")
    fun deleteAll()
}