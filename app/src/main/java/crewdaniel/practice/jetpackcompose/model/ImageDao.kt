package crewdaniel.practice.jetpackcompose.model

import androidx.room.Query

interface ImageDao {
    @Query("SELECT * FROM image_table")
    fun getImageList(): List<Image>
}