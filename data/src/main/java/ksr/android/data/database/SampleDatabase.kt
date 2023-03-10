package ksr.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ksr.android.data.model.SampleEntity

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
abstract class SampleDatabase: RoomDatabase() {

    abstract fun sampleDao(): SampleDao

}