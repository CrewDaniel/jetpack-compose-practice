package crewdaniel.practice.jetpackcompose.di

import android.content.Context
import crewdaniel.practice.jetpackcompose.data.PhotoDao
import crewdaniel.practice.jetpackcompose.data.PhotoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PhotoDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): PhotoDatabase {
        return PhotoDatabase.getDatabase(appContext)
    }

    @Provides
    fun providePhotoDao(database: PhotoDatabase): PhotoDao {
        return database.PhotoDao()
    }
}