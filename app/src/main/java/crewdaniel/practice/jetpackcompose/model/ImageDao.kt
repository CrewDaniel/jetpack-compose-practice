package crewdaniel.practice.jetpackcompose.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Query("SELECT * FROM image_table")
    fun getImageList(): Flow<List<Image>>
}