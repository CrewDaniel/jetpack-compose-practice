package crewdaniel.practice.jetpackcompose.camera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import crewdaniel.practice.jetpackcompose.data.PhotoRepository
import crewdaniel.practice.jetpackcompose.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    fun insertPhoto(uri: String) {
        viewModelScope.launch {
            repository.insertPhoto(Photo(uri = uri))
        }
    }
}