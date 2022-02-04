package crewdaniel.practice.jetpackcompose.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import crewdaniel.practice.jetpackcompose.data.ImageRepository
import crewdaniel.practice.jetpackcompose.model.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ImageRepository
): ViewModel() {
    val images = repository.imageList

    fun insertImage(image: Image) {
        viewModelScope.launch {
            repository.insertImage(image)
        }
    }
}