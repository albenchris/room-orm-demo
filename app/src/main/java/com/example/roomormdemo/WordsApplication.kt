package com.example.roomormdemo

import android.app.Application

class WordsApplication : Application() {
    // Using lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { WordRoomDatabase.getDatabase(this) }
    val repository by lazy { WordRepository(database.wordDao()) }
}