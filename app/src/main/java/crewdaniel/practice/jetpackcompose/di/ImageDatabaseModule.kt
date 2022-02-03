package crewdaniel.practice.jetpackcompose.di

import android.content.Context
import crewdaniel.practice.jetpackcompose.data.ImageDao
import crewdaniel.practice.jetpackcompose.data.ImageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ImageDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ImageDatabase {
        return ImageDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideImageDao(database: ImageDatabase): ImageDao {
        return database.imageDao()
    }
}