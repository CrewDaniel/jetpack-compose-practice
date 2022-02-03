package crewdaniel.practice.jetpackcompose.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import crewdaniel.practice.jetpackcompose.model.Image
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Query("SELECT * FROM image_table")
    fun getImageList(): Flow<List<Image>>

    @Insert
    suspend fun insertImage(image: Image)
}