package crewdaniel.practice.jetpackcompose.data

import crewdaniel.practice.jetpackcompose.model.Image
import crewdaniel.practice.jetpackcompose.model.ImageDao
import kotlinx.coroutines.flow.Flow

class ImageRepository(private val imageDao: ImageDao) {
    val imageList: Flow<List<Image>> = imageDao.getImageList()
}