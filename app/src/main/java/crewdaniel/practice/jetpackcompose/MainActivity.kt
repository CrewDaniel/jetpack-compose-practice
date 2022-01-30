package crewdaniel.practice.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import crewdaniel.practice.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    JetpackComposeTheme {
        //  화면 바꾸기
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    MainScaffold()
}

@Composable
fun MainScaffold() {
    Scaffold(
        topBar = { MainTopAppBar() },
        floatingActionButton = { MainFab() }
    ) {
        MainBody(it)
    }
}

@Composable
fun MainTopAppBar() {
    TopAppBar(title = { Text(text = "Camera Roll") })
}

@Composable
fun MainFab() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.CameraAlt,
            contentDescription = "open camera"
        )
    }
}

@Composable
fun MainBody(paddingValues: PaddingValues) {
    Surface(modifier = Modifier.padding(paddingValues = paddingValues)) {
        ImageList()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageList(images: List<Image> = listOf(Image("1"), Image("2"), Image("3"), Image("4"))) {
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
    ImageList(listOf(Image("title")))
}
