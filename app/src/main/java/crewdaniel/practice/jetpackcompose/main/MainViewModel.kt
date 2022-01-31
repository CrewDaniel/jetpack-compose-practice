package crewdaniel.practice.jetpackcompose.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import crewdaniel.practice.jetpackcompose.model.Image

class MainViewModel : ViewModel() {
    var images = mutableStateListOf<Image>()
        private set
}