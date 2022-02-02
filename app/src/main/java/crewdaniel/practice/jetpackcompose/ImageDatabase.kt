package crewdaniel.practice.jetpackcompose

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import crewdaniel.practice.jetpackcompose.model.Image
import crewdaniel.practice.jetpackcompose.model.ImageDao

@Database(entities = [Image::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao

    companion object {
        @Volatile
        private var INSTANCE: ImageDatabase? = null

        fun getDatabase(context: Context): ImageDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ImageDatabase::class.java,
                    "image_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}