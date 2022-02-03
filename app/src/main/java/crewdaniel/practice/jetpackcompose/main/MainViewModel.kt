package crewdaniel.practice.jetpackcompose.main

import androidx.lifecycle.ViewModel
import crewdaniel.practice.jetpackcompose.data.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ImageRepository
): ViewModel() {
    val images = repository.imageList
}