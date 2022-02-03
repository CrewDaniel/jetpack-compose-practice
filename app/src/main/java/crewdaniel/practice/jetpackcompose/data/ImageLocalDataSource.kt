package crewdaniel.practice.jetpackcompose.data

import crewdaniel.practice.jetpackcompose.model.Image
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageLocalDataSource @Inject constructor(private val imageDao: ImageDao) {

    val imageList: Flow<List<Image>> = imageDao.getImageList()
}