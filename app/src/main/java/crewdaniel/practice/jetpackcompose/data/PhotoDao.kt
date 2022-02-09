package crewdaniel.practice.jetpackcompose.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import crewdaniel.practice.jetpackcompose.model.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photo_table")
    fun getImageList(): Flow<List<Photo>>

    @Insert
    suspend fun insertImage(photo: Photo)
}