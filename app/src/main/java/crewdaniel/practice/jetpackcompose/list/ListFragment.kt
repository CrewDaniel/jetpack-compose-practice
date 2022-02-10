package crewdaniel.practice.jetpackcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import coil.compose.rememberImagePainter
import crewdaniel.practice.jetpackcompose.list.ListViewModel
import crewdaniel.practice.jetpackcompose.ui.theme.JetpackComposeTheme
import crewdaniel.practice.jetpackcompose.model.Photo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private val listViewModel by viewModels<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        setContent {
            ListScreen(listViewModel, { destination -> findNavController().navigate(destination) })
        }
    }
}

@Composable
fun ListScreen(mainViewModel: ListViewModel, onNavigate: (Int) -> Unit) {
    val images by mainViewModel.images.collectAsState(listOf())
    JetpackComposeTheme {
        MainScaffold(images, onNavigate)
    }
}

@Composable
fun MainScaffold(photos: List<Photo>, onNavigate: (Int) -> Unit) {
    Scaffold(
        topBar = { MainTopAppBar() },
        floatingActionButton = { MainFab(onNavigate) }
    ) {
        MainBody(it, photos)
    }
}

@Composable
fun MainTopAppBar() {
    TopAppBar(title = { Text(text = "Camera Roll") })
}

@Composable
fun MainFab(onNavigate: (Int) -> Unit) {
    FloatingActionButton(onClick = { onNavigate(R.id.nav_camera) }) {
        Icon(
            imageVector = Icons.Filled.CameraAlt,
            contentDescription = "Open Camera"
        )
    }
}

@Composable
fun MainBody(paddingValues: PaddingValues, photos: List<Photo>) {
    Surface(modifier = Modifier.padding(paddingValues = paddingValues)) {
        ImageList(photos)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageList(photos: List<Photo>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(photos) { image ->
            ImageItem(photo = image)
        }
    }
}

@Composable
fun ImageItem(photo: Photo) {
    Card {
        Image(
            painter = rememberImagePainter(photo.uri),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
    }
}
