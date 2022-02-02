package crewdaniel.practice.jetpackcompose.main

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import crewdaniel.practice.jetpackcompose.data.ImageRepository
import crewdaniel.practice.jetpackcompose.model.Image

class MainViewModel(private val repository: ImageRepository) : ViewModel() {
    val images = repository.imageList
}