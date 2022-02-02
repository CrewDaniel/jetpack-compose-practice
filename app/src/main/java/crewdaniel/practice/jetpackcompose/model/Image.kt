package crewdaniel.practice.jetpackcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class Image(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String
)
