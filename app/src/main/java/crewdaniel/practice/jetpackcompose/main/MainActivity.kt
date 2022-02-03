package crewdaniel.practice.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import crewdaniel.practice.jetpackcompose.ui.theme.JetpackComposeTheme
import crewdaniel.practice.jetpackcompose.main.MainViewModel
import crewdaniel.practice.jetpackcompose.model.Image
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(mainViewModel)
        }
    }
}

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val images by mainViewModel.images.collectAsState(listOf())
    JetpackComposeTheme {
        MainScaffold(images, { image -> mainViewModel.insertImage(image) })
    }
}

@Composable
fun MainScaffold(images: List<Image>, onClick: (Image) -> Unit) {
    Scaffold(
        topBar = { MainTopAppBar() },
        floatingActionButton = { MainFab(onClick = onClick) }
    ) {
        MainBody(it, images)
    }
}

@Composable
fun MainTopAppBar() {
    TopAppBar(title = { Text(text = "Camera Roll") })
}

@Composable
fun MainFab(onClick: (Image) -> Unit) {
    FloatingActionButton(onClick = { onClick(Image(title = "title")) }) {
        Icon(
            imageVector = Icons.Filled.CameraAlt,
            contentDescription = "open camera"
        )
    }
}

@Composable
fun MainBody(paddingValues: PaddingValues, images: List<Image>) {
    Surface(modifier = Modifier.padding(paddingValues = paddingValues)) {
        ImageList(images)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageList(
    images: List<Image> = listOf(
        Image(title = "1"),
        Image(title = "2"),
        Image(title = "3"),
        Image(title = "4")
    )
) {
    LazyVerticalGrid(cells = GridCells.Fixed(3)) {
        items(images) { image ->
            ImageItem(image = image)
        }
    }
}

@Composable
fun ImageItem(image: Image) {
    Card {
        Text(text = image.title)
    }
}

@Preview
@Composable
fun PreviewImageList() {
    ImageList(listOf(Image(title = "title")))
}
