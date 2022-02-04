package crewdaniel.practice.jetpackcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import crewdaniel.practice.jetpackcompose.list.ListViewModel
import crewdaniel.practice.jetpackcompose.ui.theme.JetpackComposeTheme
import crewdaniel.practice.jetpackcompose.model.Image
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
fun MainScaffold(images: List<Image>, onNavigate: (Int) -> Unit) {
    Scaffold(
        topBar = { MainTopAppBar() },
        floatingActionButton = { MainFab(onNavigate) }
    ) {
        MainBody(it, images)
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
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
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
