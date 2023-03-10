package ksr.android.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ksr.android.data.model.SampleEntity

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sampleEntity: SampleEntity)

    @Query("DELETE FROM sample")
    fun deleteAll()

    @Query("SELECT * FROM sample")
    fun getSample(): SampleEntity

    @Query("SELECT * FROM sample WHERE title = :title")
    fun getSample(title: String): SampleEntity
}