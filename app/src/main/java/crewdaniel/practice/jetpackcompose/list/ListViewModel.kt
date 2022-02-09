package crewdaniel.practice.jetpackcompose.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import crewdaniel.practice.jetpackcompose.data.PhotoRepository
import crewdaniel.practice.jetpackcompose.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: PhotoRepository
): ViewModel() {
    val images = repository.photoList

    fun insertPhoto(photo: Photo) {
        viewModelScope.launch {
            repository.insertPhoto(photo)
        }
    }
}