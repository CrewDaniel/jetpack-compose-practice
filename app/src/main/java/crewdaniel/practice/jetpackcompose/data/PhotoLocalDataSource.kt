package crewdaniel.practice.jetpackcompose.data

import crewdaniel.practice.jetpackcompose.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoLocalDataSource @Inject constructor(private val photoDao: PhotoDao) {

    val photoList: Flow<List<Photo>> = photoDao.getImageList()

    suspend fun insertPhoto(photo: Photo) = photoDao.insertImage(photo)
}