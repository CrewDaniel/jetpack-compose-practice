package crewdaniel.practice.jetpackcompose.data

import crewdaniel.practice.jetpackcompose.model.Image
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val localDataSource: ImageLocalDataSource
) {
    val imageList: Flow<List<Image>> = localDataSource.imageList

    suspend fun insertImage(image: Image) = localDataSource.insertImage(image)
}