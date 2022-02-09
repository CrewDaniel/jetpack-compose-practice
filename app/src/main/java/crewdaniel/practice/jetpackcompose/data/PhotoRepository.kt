package crewdaniel.practice.jetpackcompose.data

import crewdaniel.practice.jetpackcompose.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val localDataSource: PhotoLocalDataSource
) {
    val photoList: Flow<List<Photo>> = localDataSource.photoList

    suspend fun insertPhoto(photo: Photo) = localDataSource.insertPhoto(photo)
}